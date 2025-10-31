package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2AllUniqueSubsets {
    private static void printSubsets(int index, List<Integer> al, List<List<Integer>> res, int[] input) {
        res.add(new ArrayList<>(al));
        for (int i = index; i < input.length; i++) {
            if (i > index && input[i] == input[i - 1]) {
                continue;
            }

            al.add(input[i]);
            printSubsets(i + 1, al, res, input);
            al.remove(al.size() - 1);
        }
    }

    public static void printSubsets(int input[]) {
        Arrays.sort(input);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        printSubsets(0, al, res, input);
        for (List<Integer> subset : res) {
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 15, 20,15};
        printSubsets(arr);
    }
}
