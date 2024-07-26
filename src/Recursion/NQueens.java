package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NQueens {
    private static boolean isSafe(int row, int col, List<List<Integer>> board, int n) {
        //check upper left diagonal
        int r =row,c=col;
        while (row>=0 && col>=0){
            if(board.get(row).get(col)==1){
                return false;
            }
            row--;col--;
        }

        //check left horizantal row
        row=r;
        col=c;
        while(col>=0){
            if(board.get(row).get(col)==1){
                return false;
            }
            col--;
        }

        //check lower left diagonal
        row=r;
        col=c;
        while (row<n&&col>=0){
            if(board.get(row).get(col)==1){
                return false;
            }
            row++;col--;
        }
        return true;
    }
    private static void nQueens(int col, int n, List<List<Integer>> board, List<List<Integer>> ans) {
        if(col==n){
            List<Integer> t = board.stream().flatMap(List::stream).collect(Collectors.toList());
            ans.add(t);
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board.get(row).set(col,1);
                nQueens(col+1,n,board,ans);
                board.get(row).set(col,0);
            }
        }
    }


    public static List<List< Integer >> nQueens(int n)
    {
        List<List< Integer >> board = new ArrayList<>();
        List<List< Integer >> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                temp.add(0);
            }
            board.add(temp);
        }
        nQueens(0,n,board,ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List< Integer >> res = nQueens(4);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
