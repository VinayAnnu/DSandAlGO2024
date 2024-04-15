package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintSubsequencesOfString {
    public static void generateSubsequences(String input, int index, String current, List<String> subsequences){
        // Base case: If we reach the end of the input string, add the current subsequence to the list
        if(index>=input.length()){
            subsequences.add(current);
            return;
        }

        // Recursive case: Include the current character at index 'index'
        generateSubsequences(input, index+1, current+input.charAt(index), subsequences);

        // Recursive case: Exclude the current character at index 'index'
        generateSubsequences(input, index+1, current, subsequences);
    }
    public static List<String> generateSubsequences(String s) {
        List<String> subsequences = new ArrayList<>();
        generateSubsequences(s, 0, "", subsequences);
        return subsequences;
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> subsequenceList = generateSubsequences(input);
        System.out.println("subsequenceList : "+subsequenceList);
        Collections.sort(subsequenceList); // Sort the subsequences to print in lexicographically ascending order
        System.out.println("All subsequences of \"" + input + "\":");
        for (String subsequence : subsequenceList) {
            if(subsequence.length()==0){
                System.out.println("blank");
                continue;
            }
            System.out.println(subsequence);
        }
    }
}
