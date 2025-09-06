package google.sequenceReconstruction;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SequenceReConstructionDriver {

  public static void main(String[] args) {

    int[] nums = {1,2,3};
    List<List<Integer>> sequences = new ArrayList<>();
    sequences.add(List.of(1,2));
    sequences.add(List.of(1,3));

    boolean result = new Solution().sequenceReconstruction(nums,sequences);
    System.out.println(result);

//    nums = new int[]{1,2,3};
//    sequences.clear();
//    sequences.add(List.of(1,2));
//    sequences.add(List.of(1,3));
//    result = new Solution().sequenceReconstruction(nums,sequences);
//    System.out.println(result); // false
  }

}

class Solution {
  public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {


    int[] indegree = new int[nums.length];
    ArrayList<Integer>[] graph = new ArrayList[nums.length];

    for(int i=0;i<graph.length;i++){
      graph[i] = new ArrayList<>();
    }


    for(List<Integer> sequence : sequences){

      for(int i =1;i<sequence.size();i++){
        int src = sequence.get(i-1);
        int dest = sequence.get(i);
        graph[src-1].add(dest-1);
        indegree[dest-1]++;
      }
    }

    List<Integer> sort = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();
    int count =0;
    for(int i=0;i< indegree.length;i++){
      if(indegree[i] == 0){
        count++;
        queue.offer(i);
      }
    }
    if(count > 1){
      return false;
    }

    while(!queue.isEmpty()){
      int curr = queue.poll();
      int val = curr +1;
      sort.add(val);
      count =0;
      for(int i =0;i<graph[curr].size();i++){
        int next = graph[curr].get(i);
        indegree[next]--;
        if(indegree[next] ==0){
          queue.offer(next);
          count++;
        }
      }
      if(count > 1){
        return false;
      }
    }


    for(int i =0;i< nums.length;i++){
      if(nums[i] != sort.get(i)){
        return false;
      }
    }
    return true;

  }
}