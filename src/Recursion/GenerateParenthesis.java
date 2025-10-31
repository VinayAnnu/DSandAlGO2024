package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(0,0,n,sb,res);
        return res;
    }
    public void generateParenthesis(int open,int close,int n,StringBuilder sb,List<String> res){
        if(open==close && open==n){//open=close=n
            res.add(sb.toString());
            return;
        }

        if(open<n){
            generateParenthesis(open+1,close,n,sb.append('('),res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        if(close<open){
            generateParenthesis(open,close+1,n,sb.append(')'),res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
