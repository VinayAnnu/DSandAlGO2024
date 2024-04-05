import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.*;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create an executor that supports virtual threads
        Float x = 4.5f;
        if(x==4.50){
            System.out.println("Equal");
        }else {
            System.out.println("Not Equal");
        }

    }
}