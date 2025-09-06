package amazon.largestVariance;

public class LargestVarianceDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().largestVariance("aababbb"));
  }
}



class Solution {
  public int largestVariance(String s) {



    int[] allChar = new int[26];
    for (char c : s.toCharArray()){
      allChar[c-'a'] = 1;
    }

    int max =0;
    for (char c = 'a'; c <= 'z'; c++) {



      for (char c2 = 'a' ; c2 <= 'z'; c2++){


        char one = c;
        char two = c2;

        if(allChar[c-'a'] == 0 || allChar[c2-'a'] ==0){
          continue;
        }

        int oneCount = 0;
        int twoCount = 0;
        boolean prvExitSecond = false;

        for (int i = 0; i < s.length(); i++) {

          if(s.charAt(i) == one){
            oneCount++;
          }

          if(s.charAt(i) == two){
            twoCount++;
          }


           if(twoCount > 0){
             max = Math.max(max,oneCount-twoCount);
           }else {
             if(prvExitSecond){
               max = Math.max(max,oneCount-1);
             }
           }

          if(twoCount > oneCount){
            twoCount =0;
            oneCount = 0;
            prvExitSecond = true;
          }

        }

      }
    }
    return max;
  }
}
