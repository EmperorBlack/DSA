package heap.replaceElementByItsRank;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class ReplaceElementByRankDriver {

  public static void main(String[] args) {

    System.out.println(
        Arrays.toString(Solution.replaceWithRank(new int[]{20, 15, 26, 2, 98, 6}, 6)));
  }
}

class Solution {
  static int[] replaceWithRank(int arr[], int N) {

    class Node{
      int index;
      int value;

      public Node(int index, int value) {
        this.index = index;
        this.value = value;
      }
    }


    Queue<Node> queue = new PriorityQueue<>((n1,n2)->Integer.compare(n1.value,n2.value));

    for (int i = 0; i < N; i++) {
      queue.offer(new Node(i,arr[i]));
    }

    int rank =1;
    int prv = Integer.MIN_VALUE;
    while (!queue.isEmpty()){
      Node node = queue.poll();
      if(prv == node.value){
        rank--;
      }
      arr[node.index] = rank;
      prv = node.value;
      rank++;
    }
    return arr;

  }
}
