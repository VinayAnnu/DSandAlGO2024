package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<Integer> getPascalRow(int rowNum){
        List<Integer> row = new ArrayList<>();
        int ans = 1;
        row.add(ans);
        for(int col = 1; col <rowNum; col++){
            ans = ans * (rowNum - col);
            ans = ans / col;
            row.add(ans);
        }
        return row;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            result.add(getPascalRow(i));
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }
}
