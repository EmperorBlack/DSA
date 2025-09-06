package heap.maxSumCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MaxSumCombinationDriver {

  public static void main(String[] args) {


    System.out.println(new Solution().solve(Arrays.asList(1,4,2,3),Arrays.asList(2,5,1,6),4));
  }


}

class Pair{
  int i; int j;
  int value;

  public Pair(int i, int j, int value) {
    this.i = i;
    this.j = j;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pair pair = (Pair) o;
    return i == pair.i && j == pair.j && value == pair.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(i, j, value);
  }
}
class Solution {
  public ArrayList<Integer> solve(List<Integer> A, List<Integer> B, int C) {

    Collections.sort(A);
    Collections.sort(B);
    Set<Pair> set = new HashSet<>();
    Queue<Pair> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p2.value,p1.value));

    Pair pair = new Pair(A.size()-1,B.size()-1,A.get(A.size()-1)+B.get(B.size()-1));
    queue.offer(pair);
    set.add(pair);
    ArrayList<Integer> result = new ArrayList<>();
    while (result.size() < C){

      Pair p = queue.poll();
      result.add(p.value);

      Pair p1 = new Pair(p.i-1,p.j,A.get(p.i-1)+ B.get(p.j));
      Pair p2 = new Pair(p.i,p.j-1,A.get(p.i)+ B.get(p.j-1));

      if(!set.contains(p1)){
        queue.offer(p1);
        set.add(p1);
      }

      if(!set.contains(p2)){
        queue.offer(p2);
        set.add(p2);
      }
    }

    return result;

  }
}
