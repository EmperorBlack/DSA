package heap.OrdinalRankTracker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class OrdinalRankTrackerDriver {

  public static void main(String[] args) {

    SORTracker s = new SORTracker();
    s.add("zzzz", 10);
    System.out.println(s.get());  // Should print "zzzz"

    s.add("aaaa", 10);
    System.out.println(s.get());  // Should print "aaaa" (better lex order)

    s.add("aaab", 10);
    System.out.println(s.get());  // Should print "aaab" (2nd best lex order)

  }
}

class Pair{

  String location;
  int rank;

  public Pair(String location, int rank) {
    this.location = location;
    this.rank = rank;
  }
}

class SORTracker {

  Queue<Pair> minHeap;
  Queue<Pair> maxHeap;
  int noOfGetCall =0;
  public SORTracker() {

    maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
      public int compare(Pair o1, Pair o2) {

        if(o1.rank == o2.rank){
          return o1.location.compareTo(o2.location);
        }else{
          return Integer.compare(o2.rank,o1.rank);
        }
      }
    });
    minHeap = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        if(o1.rank == o2.rank){
          return o2.location.compareTo(o1.location);
        }else{
          return Integer.compare(o1.rank,o2.rank);
        }
      }
    });
  }

  public void add(String name, int score) {
    minHeap.offer(new Pair(name,score));
    if(minHeap.size() > noOfGetCall){
      maxHeap.offer(minHeap.poll());
    }
  }

  public String get() {

    noOfGetCall++;
    if(noOfGetCall > minHeap.size()){
      minHeap.offer(maxHeap.poll());
    }
    return minHeap.peek().location;

  }
}
