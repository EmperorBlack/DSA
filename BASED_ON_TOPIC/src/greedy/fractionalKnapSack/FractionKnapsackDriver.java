package greedy.fractionalKnapSack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FractionKnapsackDriver {

}
// User function Template for Java

class Pair{
  int val;
  int wt;
  double unitVal;

  public Pair(int wt, int val) {
    this.wt = wt;
    this.val = val;
    this.unitVal = (val/(wt*1.0d));
  }
}
class Solution {
  // Function to get the maximum total value in the knapsack.
  double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
    // code here

    Queue<Pair> queue = new PriorityQueue<>((p1,p2)-> Double.compare(p2.unitVal,p1.unitVal));

    for (int i = 0; i < val.size(); i++) {
      queue.offer(new Pair(wt.get(i),val.get(i)));
    }

    double value = 0d;
    while (!queue.isEmpty() && capacity > 0){

      Pair p = queue.poll();
      if(p.wt <= capacity){
        value += p.val;
        capacity = capacity-p.wt;
      }else{
        value += p.unitVal*capacity;
        capacity = 0;
      }
    }
    return value;

  }
}

class Solution_sort {
  // Function to get the maximum total value in the knapsack.
  double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
    // code here

    List<Pair> list = new ArrayList<>();

    for (int i = 0; i < val.size(); i++) {
      list.add(new Pair(wt.get(i),val.get(i)));
    }

    list.sort((p1, p2) -> Double.compare(p2.unitVal, p1.unitVal));

    double value = 0d;
    int i =0;
    while (capacity > 0 && i < list.size()){

      Pair p = list.get(i);
      if(p.wt <= capacity){
        value += p.val;
        capacity = capacity-p.wt;
      }else{
        value += p.unitVal*capacity;
        capacity = 0;
      }
      i++;
    }
    return value;

  }
}

