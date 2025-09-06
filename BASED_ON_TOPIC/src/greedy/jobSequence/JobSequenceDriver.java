package greedy.jobSequence;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequenceDriver {

  public static void main(String[] args) {

    ArrayList<Integer> ids = new ArrayList<>(Arrays.asList());
    ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(20, 1, 40, 30));
    ArrayList<Integer> deadline = new ArrayList<>(Arrays.asList(4, 1, 1, 1));

    System.out.println(new Solution().JobSequencing(new int[]{1, 2, 3, 4},new int[]{4, 1, 1, 1},new int[]{20, 1, 40, 30}));
  }
}

class Pair{
  int id;
  int profit;
  int deadLine;

  public Pair(int id, int profit, int deadLine) {
    this.id = id;
    this.profit = profit;
    this.deadLine = deadLine;
  }
}

// inner loop can replace with DSU. we can optimise more
class Solution {

  public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
    // code here..

    ArrayList<Pair> list = new ArrayList<>();
    int maxDeadline = 0;
    for (int i = 0; i < id.length; i++) {
      list.add(new Pair(id[i],profit[i],deadline[i]));
      maxDeadline = Math.max(maxDeadline,deadline[i]);
    }
    list.sort((p1,p2)-> Integer.compare(p2.profit,p1.profit));
    int[] deadlines = new int[maxDeadline];
    Arrays.fill(deadlines,-1);

    int maxProfit = 0;
    int count = 0;
    for (int i = 0; i < list.size(); i++) {

      Pair p = list.get(i);
      int index = p.deadLine-1;// o based indexing
      while (index >= 0 && deadlines[index] !=-1){
        index = index-1;
      }

      if(index >= 0){
        deadlines[index] = p.id;
        maxProfit += p.profit;
        count++;
      }

    }
    ArrayList<Integer> result = new ArrayList<>();
    result.add(count);
    result.add(maxProfit);
    return result;


  }
}