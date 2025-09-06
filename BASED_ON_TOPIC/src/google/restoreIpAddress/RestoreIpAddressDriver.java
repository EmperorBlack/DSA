package google.restoreIpAddress;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddressDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().restoreIpAddresses("25525"));
  }
}

class Solution {
  public List<String> restoreIpAddresses(String s) {

    List<String> result = new ArrayList<>();
    generateValidIpAddress(s,0,0,new StringBuilder(),result);
    return result;

  }

  private void generateValidIpAddress(String s, int index,int dotCount, StringBuilder temp, List<String> result){



    if(dotCount > 3){
      return;
    }

    if(index ==  s.length()){
      if(dotCount == 3){
        result.add(temp.toString());
        return;
      }
      return;
    }

    int num = 0;
    int length = temp.length();
    StringBuilder sb = new StringBuilder();
    for(int i=index;i< Math.min((index+3),s.length()) ;i++){

      if(i > index && s.charAt(index) == '0'){
        break;
      }
      int digit = Character.getNumericValue(s.charAt(i));
      num = (num*10) + digit;
      sb.append(digit);
      int newDotCount = 0;
      if(num <= 255){
        if(index > 0){
          temp.append(".").append(sb);
          newDotCount = dotCount+1;
        }else {
          temp.append(num);
          newDotCount = dotCount;
        }
        generateValidIpAddress(s,i+1,newDotCount, temp,result);
        temp.delete(length,temp.length());
      }

    }

  }
}
