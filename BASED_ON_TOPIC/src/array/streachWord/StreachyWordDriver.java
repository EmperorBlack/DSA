package array.streachWord;

import java.util.ArrayList;
import java.util.List;

public class StreachyWordDriver {

  public static void main(String[] args) {

  }
}

class Streachy{
  String word;
  List<Integer> counts;

  public Streachy(String word) {
    counts = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int count =0;
    char prev = word.charAt(0);

    for(int i=0;i<word.length();i++){
      if(word.charAt(i) != prev){
        counts.add(count);
        count = 1;
        sb.append(prev);
        prev = word.charAt(i);
      }else{
        count++;
      }
    }
    counts.add(count);
    sb.append(prev);
    this.word = sb.toString();
  }
}


class Solution {
  public int expressiveWords(String s, String[] words) {

    Streachy first = new Streachy(s);

    int ans =0;
    for(String word : words){
      Streachy second = new Streachy(word);
      if(!first.word.equals(second.word)){
        continue;
      }
      boolean isStreachy = true;
      for (int i = 0; i < first.counts.size(); i++) {
        int c1 = first.counts.get(i);
        int c2 = second.counts.get(i);
        if(c1 < c2 || (c1 != c2 && c1 < 3)){
          isStreachy = false;
          break;
        }
      }
      if(isStreachy){
        ans++;
      }
    }
    return ans;


  }
}
