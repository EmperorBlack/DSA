package dp.maxRepeatingSubString;

public class MaxRepetingSubDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
  }
}

class Solution {
  public int maxRepeating(String sequence, String word) {


    int len = word.length();
    int count =0;
    StringBuilder sb = new StringBuilder();
    int l = 0;
    for (int i = 0; i < sequence.length(); i++) {

      sb.append(sequence.charAt(i));
      if((i-l+1) > len){
        sb.delete(0,1);
        l++;
      }

      if(sb.toString().equals(word)){
        count++;
      }

    }
    return count;

  }


}