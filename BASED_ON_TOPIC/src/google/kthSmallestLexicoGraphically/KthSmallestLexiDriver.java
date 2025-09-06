package google.kthSmallestLexicoGraphically;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestLexiDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_2().findKthNumber(2,2));
  }
}


class Solution {
  public int findKthNumber(int n, int k) {

    Queue<String> queue = new PriorityQueue<>((s1,s2)-> s2.compareTo(s1));
    for (int i = 1; i <= n; i++) {
      queue.offer(String.valueOf(i));
      if(queue.size() > k){
        queue.poll();
      }
    }
    return Integer.parseInt(queue.peek());
  }
}


class Solution_2 {
  private int count = 0;
  private int result = 0;

  public int findKthNumber(int n, int k) {
    for (int i = 1; i <= 9; i++) {
      if (count >= k) break;
      dfs(n, k, i);
    }
    return result;
  }

  private void dfs(int n, int k, long current) {
    if (current > n) return;

    count++;
    if (count == k) {
      result = (int) current;
      return;
    }

    for (int i = 0; i <= 9; i++) {
      long next = current * 10 + i;
      if (next > n) return;
      dfs(n, k, next);
    }
  }
}

class Solution_3_leetcode {
  public int findKthNumber(int n, int k) {

    int curr = 1;
    k--;

    while(k >0){

      int steps = countSteps(n,curr,curr+1);
      if(steps <=k ){
        k = k -steps;
        curr++;
      }else{
        curr = curr*10;
        k--;
      }

    }
    return curr;

  }

  private int countSteps(int n, long prefix1, long prefix2){
    int steps = 0;
    while(prefix1 <= n){

      steps += (int) (Math.min(n + 1, prefix2) - prefix1);
      prefix1 = prefix1 *10;
      prefix2 = prefix2 * 10;
    }
    return steps;
  }



}