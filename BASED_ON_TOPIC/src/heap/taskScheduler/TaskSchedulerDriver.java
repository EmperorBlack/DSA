package heap.taskScheduler;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedulerDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().leastInterval(new char[]{'A','A','A','B','B','B'},2));
  }
}

class Task{
  int startTime;
  int frq;

  public Task(int startTime, int frq) {
    this.startTime = startTime;
    this.frq = frq;
  }
}

//priority Queue approach
class Solution {
  public int leastInterval(char[] tasks, int n) {

    Map<Character,Integer> map = new HashMap<>();
    for (char task : tasks){
      map.put(task,map.getOrDefault(task,0)+1);
    }

    Queue<Task> pq = new PriorityQueue<>((t1,t2)->Integer.compare(t2.frq,t1.frq));
    for (Map.Entry<Character,Integer> entry : map.entrySet()){
      pq.offer(new Task(0,entry.getValue()));
    }

    Queue<Task> queue = new ArrayDeque<>();
    int interval = 0;
    while (!pq.isEmpty() || !queue.isEmpty()){

      interval++;
      if(!pq.isEmpty()){
        Task task = pq.poll();
        task.frq--;
        task.startTime = interval;
        if(task.frq > 0){
          queue.offer(task);
        }
      }

      if(!queue.isEmpty() && (interval - queue.peek().startTime) >= n ){
        pq.offer(queue.poll());
      }
    }


    return interval;
  }
}