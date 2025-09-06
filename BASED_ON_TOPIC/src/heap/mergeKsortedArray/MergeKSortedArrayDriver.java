package heap.mergeKsortedArray;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrayDriver {

  public static void main(String[] args) {

  }
}


class Solution
{

  //Function to merge k sorted arrays.
  public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
  {

    ArrayList<Integer> list = new ArrayList<>();
    class Node {

      int row;
      int col;
      int val;

      public Node(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
      }
    }

    Queue<Node> queue = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));


    int j =0;
    for(int i=0;i< K;i++){
      queue.offer(new Node(i,j,arr[i][j]));
    }

    while (!queue.isEmpty()){
      Node node = queue.poll();
      list.add(node.val);
      if(node.col < K-1){
        queue.add(new Node(node.row, node.col+1,arr[node.row][node.col+1] ));
      }
    }


    return list;
  }
}