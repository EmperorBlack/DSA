package greedy.assignCoockies;

import java.util.Arrays;

public class AssignCookiesDriver {

}

class Solution {
  public int findContentChildren(int[] g, int[] s) {

    Arrays.sort(g);
    Arrays.sort(s);

    int i = g.length-1;
    int j = s.length-1;
    int count =0;
    while (i >=0 && j >=0){
      if(g[i] <= s[j]){
        i--;
        j--;
        count++;
      } else {
        i--;
      }
    }
    return count;
  }
}

class Solution_s {
  public int findContentChildren(int[] g, int[] s) {

    Arrays.sort(g);
    Arrays.sort(s);

    int i = 0;
    int j = 0;
    while (i < g.length && j < s.length){
      if(g[i] <= s[j]){
        i++;
        j++;
      } else {
        j++;
      }
    }
    return i-1;
  }
}
