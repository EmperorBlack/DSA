package randomPractice.binaryStrings;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringDriver {

  public static void main(String[] args) {

    System.out.println(Solution.generateBinaryStrings(3));
  }
}


class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> result = new ArrayList<>();
    generate(false,"",0,result,n);
    return result;

  }

  private static void generate(boolean flag,String temp,int index, List<String> result,int n ){

    if(index == n){
      result.add(new String(temp));
      return;
    }

    generate(false,temp+"0",index+1, result,n);
    if(!flag){
      generate(true,temp+"1",index+1,result,n);
    }
  }
}

