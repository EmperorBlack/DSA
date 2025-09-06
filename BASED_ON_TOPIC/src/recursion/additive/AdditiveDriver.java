package recursion.additive;

import java.util.ArrayList;
import java.util.List;

public class AdditiveDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().isAdditiveNumber("011112"));
  }

}

class Solution {
  public boolean isAdditiveNumber(String num) {


    if(num.length() < 3){
      return false;
    }



    return isAdditive(num,0,new ArrayList<>());
  }

  private boolean isAdditive(String num,int start, List<Long> temp){
    if(start == num.length()){
      int size = temp.size();
      if(size >= 3 && (temp.get(size-2)+temp.get(size-3) == temp.get(size-1))){
        return true;
      }else{
        return false;
      }

    }


    StringBuilder sb = new StringBuilder();
    for(int i = start; i<num.length(); i++){
      sb.append(num.charAt(i));
      long next = Long.parseLong(sb.toString());
      if(temp.size() < 2){
        temp.add(next);
        if(isAdditive(num,i+1,temp)){
          return true;
        }
        temp.remove(temp.size()-1);
      }else{
        long num1 = temp.get(temp.size()-1);
        long num2 = temp.get(temp.size()-2);
        if(num1+num2 == next){
          temp.add(next);
          if(isAdditive(num,i+1,temp)){
            return true;
          }
          temp.remove(temp.size()-1);
        }

      }
      if(next == 0){
        break;
      }


    }
    return false;


  }
}
