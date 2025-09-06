package google.kmpAlgo;

import java.util.ArrayList;

public class KMPDriver {

  public static void main(String[] args) {

  }
}


class Solution {

  ArrayList<Integer> search(String pat, String txt) {
    // your code here

    ArrayList<Integer> result = new ArrayList<>();
    int[] lps = computeLps(pat);

    int i =0;
    int j =0;
    while(i < txt.length()){


      if(txt.charAt(i) == pat.charAt(j)){
        i++;
        j++;
      }else{
        if(j == 0){
          i++;
        }else{
          j = lps[j-1];
        }
      }

      if(j == pat.length()){
        result.add(i - j);
        j = lps[j-1];
      }
    }
    return result;


  }

  private int[] computeLps(String pat){
    int n = pat.length();
    int[] lps = new int[n];
    int prefix = 0;
    int suffix = 1;
    while(suffix < n){
      if(pat.charAt(prefix) == pat.charAt(suffix)){
       lps[suffix] = prefix + 1;
       prefix++;
       suffix++;
      }else{
        if(prefix == 0){
          lps[suffix] = 0;
          suffix++;
        }else{
          prefix = lps[prefix - 1];
        }
      }
    }
    return lps;
  }
}
//class Solution {
//
//  public int[] findLPS(String s){
//    int n = s.length();
//    int [] lps = new int[n];
//    int prefix =0;
//    int suffix = 1;
//
//    while(suffix < n){
//      if(s.charAt(prefix) == s.charAt(suffix)){
//        lps[suffix] = prefix + 1;
//        prefix++;
//        suffix++;
//      }else{
//        if(prefix == 0){
//          lps[suffix] =0;
//          suffix++;
//        }else{
//          prefix = lps[prefix-1];
//        }
//      }
//    }
//  }
//
//
//}