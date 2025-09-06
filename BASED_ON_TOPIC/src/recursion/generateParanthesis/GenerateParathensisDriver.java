package recursion.generateParanthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParathensisDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_2().generateParenthesis(1));
  }
}

class Solution {
  public List<String> generateParenthesis(int n) {


    int left = n-1;
    int right = n;
    List<String> result = new ArrayList<>();
    generateParenthesisHelper(left,right,result,"(","");
    return result;
  }

  public void generateParenthesisHelper(int left, int right, List<String> result, String curr, String temp) {

    temp = temp+curr;
    if(left ==0 && right ==0){
      result.add(temp);
      return;
    }

    if(curr.equals("(")){
      if(left > 0){
        generateParenthesisHelper(left-1,right,result,"(",temp);
      }
      generateParenthesisHelper(left,right-1,result,")",temp);
    }else {
      if(left <= right && left > 0){
        generateParenthesisHelper(left-1,right,result,"(",temp);
      }
      if(right > 0){
        generateParenthesisHelper(left,right-1,result,")",temp);
      }
    }


  }
}

class Solution_2 {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();

    generateAllParenthesis(n,0,0,"",result);
    return result;
  }

  public void generateAllParenthesis(int max,int open, int close,String par,List<String> result) {

    if(par.length() == max*2){
      result.add(par);
      return;
    }

    if(open < max){
      generateAllParenthesis(max,open+1,close,par+"(",result);
    }
    if(close < open){
      generateAllParenthesis(max,open,close+1,par+")",result);
    }

  }
}