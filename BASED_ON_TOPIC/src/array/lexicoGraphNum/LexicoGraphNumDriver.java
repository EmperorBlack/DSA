package array.lexicoGraphNum;

import java.util.ArrayList;
import java.util.List;

public class LexicoGraphNumDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().lexicalOrder(13));
  }
}

class Solution {
  public List<Integer> lexicalOrder(int n) {

    List<Integer> result = new ArrayList<>();
    for(int i =1;i<= 9;i++){
      generateLexicalNumbers(i,n,result);
    }
    return result;

  }

  private void generateLexicalNumbers(int currNum, int limit, List<Integer> result){

    if(currNum > limit){
      return;
    }

    result.add(currNum);

    for(int i=0;i<= 9;i++){
      int nextNum = currNum*10 + i;
      generateLexicalNumbers(nextNum,limit, result);
    }
  }
}
