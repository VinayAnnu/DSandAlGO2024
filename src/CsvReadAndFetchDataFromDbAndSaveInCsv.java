//package com.landmark.loipl.service;
//
//import com.landmark.loipl.entity.LiDPTatDetails;
//import com.landmark.loipl.exception.BaseException;
//import com.landmark.loipl.exception.ValidationException;
//import com.landmark.loipl.repository.DPTatDetailsRepository;
//import com.landmark.loipl.util.CsvUtil;
//import com.landmark.loipl.util.NullCheckUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//@Service
//public class CsvReadAndFetchDataFromDbAndSaveInCsv {
//    Logger logger = LoggerFactory.getLogger(CsvReadAndFetchDataFromDbAndSaveInCsv.class);
////    properties file--------
////    oms-data-file-location=/cpsmartsourceservice/OMSfiles/
////    oms-data-file-name=OMS_DpZone_Analysis
////    oms-data-file-headers-to-accept=Delivery pincode,FC ID
////    oms-data-file-archive=/cpsmartsourceservice/OMSfiles/archived/
////    oms-data-analysis-result-file=/cpsmartsourceservice/OMSfiles/result/
//
//    @Value("${oms-data-file-location}")
//    private String fileLocation;
//
//    @Value("${oms-data-file-name}")
//    private String fileName;
//    @Value("#{'${oms-data-file-headers-to-accept}'.split(',')}")
//    private List<String> fileHeadersToAccept;
//    @Value("${oms-data-file-archive}")
//    String archivePath;
//    @Value("${oms-data-analysis-result-file}")
//    String resultPath;
//    @Autowired
//    DPTatDetailsRepository dpTatDetailsRepository;
//
//    public Map<String, String> fetchFileDetails() {
//        try {
//            File files = CsvUtil.getFilesFromLocation(CsvUtil.getDirectory() + fileLocation);
//            File[] listOfFiles = files.listFiles((file, name) -> name.startsWith(fileName)
//                    && name.endsWith(".csv"));
//            if (listOfFiles.length == 0) {
//                throw new FileNotFoundException("NO_FILE_FOUND_IN_DIRECTORY");
//            }
//            return processFile(listOfFiles);
//        } catch (Exception e) {
//            logger.error("Exception occurred while FetchFileDetails file from directory: {}", e.getMessage());
//        }
//        return null;
//    }
//
//    private Map<String, String> processFile(File[] listOfFiles) {
//        HashMap<String, String> responseMap = new HashMap<>();
//
//        List<File> sortedDpTatFiles = Arrays.stream(listOfFiles).sorted(Collections.reverseOrder()).collect(Collectors.toList());
//        for (File file : sortedDpTatFiles) {
//            String response = readFile(file);
//            responseMap.put(file.getName(), response);
//        }
//        return responseMap;
//    }
//
//    public String readFile(File file) {
//        String response = "SUCCESS";
//        List<Map<String, String>> data;
//        List<LiDPTatDetails> liDPTatDetails = new ArrayList<>();
//        try {
//            data = readCsv(file.toString(), fileHeadersToAccept);
//        } catch (BaseException | ValidationException exception) {
//            response = "FAILURE";
//            logger.error("Unable to read file !!!, exception msg : {}", exception.getMessage());
//            return response;
//        }
//
//        try {
//            if (!data.isEmpty()) {
//                FetchAndWriteIntoCsv(data, liDPTatDetails);
//                insertIntoCsvFile(liDPTatDetails);
//            }
//        } catch (BaseException e) {
//            response = "FAILURE";
//            logger.error("Exception occured due to : {}", e.getMessage());
//            return response;
//        } catch (IOException e) {
//            logger.error("IOException occured due to : {}", e.getMessage());
//            return response;
//        }
//        //CsvUtil.moveToBackupFolder(file, dpTatDetailsConfig.getArchivePath());
//        return response;
//    }
//
//    private void FetchAndWriteIntoCsv(List<Map<String, String>> data, List<LiDPTatDetails> liDPTatDetails) throws BaseException {
//        for (Map<String, String> mapData : data) {
//            fetchDetailsFromDb(mapData, liDPTatDetails);
//        }
//    }
//
//    private void fetchDetailsFromDb(Map<String, String> mapData, List<LiDPTatDetails> liDPTatDetails) throws BaseException {
//        try {
//            String customerPincode = mapData.get("Delivery pincode");
//            Integer fcId = Integer.parseInt(mapData.get("FC ID"));
//            List<LiDPTatDetails> dataListFetchedFromDB = dpTatDetailsRepository.findAllByIdCustomerPincodeAndIdFcId(customerPincode, fcId);
//            if(dataListFetchedFromDB != null){
//                liDPTatDetails.addAll(dataListFetchedFromDB);
//            }
//        } catch (Exception e) {
//            throw new BaseException("Exception occured : " + e.getMessage());
//        }
//    }
//
//    private void insertIntoCsvFile(List<LiDPTatDetails> dataListFetchedFromDB) throws IOException {
//        String[] stringArray = {"customerPincode", "fcId", "dpZone", "shipMethod"};
//        List<String> outputHeaders = Arrays.asList(stringArray);
//        LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Kolkata"));
//        String outputFilePath = resultPath + "output" + localDate + ".csv";
//        BufferedWriter writer = Files.newBufferedWriter(Paths.get(getDirectory() +outputFilePath));
//        writer.write(outputHeaders.stream().map(String::valueOf).collect(Collectors.joining(",")));
//        writer.newLine();
//        for(LiDPTatDetails liDPTatDetails : dataListFetchedFromDB){
//            String cuPin = liDPTatDetails.getId().getCustomerPincode();
//            String fcId = String.valueOf(liDPTatDetails.getId().getFcId());
//            String dpZone = liDPTatDetails.getDpZone();
//            String shipMethod = liDPTatDetails.getId().getShipMethod();
//            String res = cuPin+","+fcId+","+dpZone+","+shipMethod;
//            writer.write(res);
//            writer.newLine();
//        }
//        writer.close();
//        logger.info("Finished writing to {} file", outputFilePath);
//    }
//    public  List<Map<String, String>> readCsv(String fileName, List<String> headersToAccept) throws BaseException, ValidationException {
//        logger.info("Started reading file: {}",fileName);
//        int i=0;
//        try {
//
//            Scanner sc = new Scanner(new File(fileName));
//            Map<Object, Object> indexesToKeep = new HashMap<>();
//            List<Map<String, String>> table = new ArrayList<>();
//            sc.useDelimiter(",");
//            if (headersToAccept != null) {
//                String[] headers = sc.nextLine().replaceAll("#", "").replaceAll("[\\uFEFF-\\uFFFF]","").split(",");
//                List<String> headersList = Arrays.asList(headers);
//                indexesToKeep = headersToAccept.stream().filter(x-> headersList.contains(x)).collect(Collectors.toMap(x -> x, x -> headersList.indexOf(x)));
//            }
//            if(indexesToKeep.size()< headersToAccept.size()) {
//                logger.error("{} not acceptable. Mandatory headers not present.",fileName);
//                throw new ValidationException(fileName+ " not acceptable. Mandatory headers not present. ");
//            }
//
//            while (sc.hasNext()) {
//                i++;
//                String[] row = sc.nextLine().replaceAll("\"", "").split(",");
//                if(NullCheckUtil.isEmpty(Arrays.asList(row))) break;
//                Map<Object, Object> finalIndexesToKeep = indexesToKeep;
//                Map<String, String> tableRow = indexesToKeep.keySet().parallelStream().collect(Collectors.toMap(x -> x.toString(), x -> row[(int) finalIndexesToKeep.get(x)]));
//                table.add(tableRow);
//
//            }
//            logger.info("No of records= {}", table.size());
//
//
//            return table;
//        }
//        catch (ValidationException ve){
//            logger.error("File not acceptable.");
//            throw new ValidationException(fileName+ " not acceptable. Mandatory headers not present. ");
//
//        }
//        catch (Exception e){
//            logger.error("error while reading file : {}, Exception: {} {} ",fileName,e.getMessage(),i);
//            throw new BaseException("error while reading file : "+fileName+" Exception: "+e.getMessage());
//        }
//
//
//    }
//
//    public static String getDirectory() {
//        return getHomeDirectory();
//    }
//
//    public static String getHomeDirectory() {
//        return System.getProperty("user.home");
//    }
//
//}
