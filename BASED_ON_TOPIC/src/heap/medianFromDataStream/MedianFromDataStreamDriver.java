package heap.medianFromDataStream;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromDataStreamDriver {

  public static void main(String[] args) {

    MedianFinder_2 mf = new MedianFinder_2();
    mf.addNum(1);
//    mf.addNum(2);
    System.out.println(mf.findMedian());
  }
}

class MedianFinder {

  Queue<Integer> maxHeap;
  Queue<Integer> minHeap;

  public MedianFinder() {
    maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {

    if(minHeap.isEmpty()){
      minHeap.offer(num);
    }else{
      if(num < minHeap.peek()){
        maxHeap.offer(num);
      }else{
        minHeap.offer(num);
      }
    }

    if((minHeap.size() > maxHeap.size()) &&  (minHeap.size() - maxHeap.size()) > 1){
      maxHeap.offer(minHeap.poll());
    }

    if(maxHeap.size() > minHeap.size()){
      minHeap.offer(maxHeap.poll());
    }
  }

  public double findMedian() {

    if(maxHeap.size() == minHeap.size()){
      return (maxHeap.peek()+minHeap.peek())/2.0d;
    }else{
      return minHeap.peek();
    }

  }
}

class MedianFinder_2 {

  Queue<Integer> maxHeap;
  Queue<Integer> minHeap;

  public MedianFinder_2() {
    maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {

    maxHeap.offer(num);

    if((maxHeap.size() > minHeap.size()) &&  (maxHeap.size() - minHeap.size()) > 1){
      minHeap.offer(maxHeap.poll());
    }

  }

  public double findMedian() {

    if(maxHeap.size() == minHeap.size()){
      return (maxHeap.peek()+minHeap.peek())/2.0d;
    }else{
      return Math.min(maxHeap.peek(),minHeap.isEmpty() ? Integer.MAX_VALUE : minHeap.peek());
    }

  }
}