package recursion.expressionOperator;

import java.util.ArrayList;
import java.util.List;

public class ExpressionOperatorDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public List<String> addOperators(String num, int target) {

    List<String> list = new ArrayList<>();
    addOperators(num,target,0,0,new StringBuilder(),list,0);
  return list;

  }

  public void addOperators(String num, int target, long eval,long residual, StringBuilder path, List<String> result, int ind) {

    if(ind == num.length()){
      if(eval == target){
        result.add(path.toString());
      }
    }

    long currNum = 0L;

    for (int i = ind; i < num.length(); i++) {

      if(i > ind && num.charAt(ind) == '0'){
        return;
      }
      currNum = 10*currNum + num.charAt(i)-'0';
      int len = path.length();
      if(ind ==0){
        addOperators(num,target,currNum,currNum,path.append(currNum),result,i+1);
        path.setLength(len);
      }else {
        addOperators(num,target,eval + currNum,currNum,path.append("+").append(currNum),result,i+1);
        path.setLength(len);

        addOperators(num,target,eval - currNum,-currNum,path.append("-").append(currNum),result,i+1);
        path.setLength(len);


        addOperators(num,target,eval - residual + residual * currNum,residual * currNum,path.append("*").append(currNum),result,i+1);
        path.setLength(len);

      }

    }



  }
}
