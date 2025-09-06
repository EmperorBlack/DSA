package recursion.betterString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BetterStringDriver {

  public static void main(String[] args) {

    System.out.println(Solution.betterString("gfg","ggg"));

//    Set

  }
}

class Solution {
  public static String betterString(String str1, String str2) {

    List<StringBuilder> sub1 = new ArrayList<>();
    List<StringBuilder> sub2 = new ArrayList<>();

    char arr1[] = str1.toCharArray();
    char arr2[] = str2.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    distinctSubString(arr1,new StringBuilder(),0,sub1);
    distinctSubString(arr2,new StringBuilder(),0,sub2);

    if(sub1.size() >= sub2.size()){
      return str1;
    }else{
      return str2;
    }

  }

  public static void distinctSubString(char[] s, StringBuilder temp,int index, List<StringBuilder> result){


    result.add(new StringBuilder(temp));
    for (int i = index; i < s.length; i++) {

      if(index == i || s[i] != s[i-1]){
        temp.append(s[i]);
        distinctSubString(s,temp,i+1,result);
        temp.deleteCharAt(temp.length()-1);
      }
    }




  }
}
