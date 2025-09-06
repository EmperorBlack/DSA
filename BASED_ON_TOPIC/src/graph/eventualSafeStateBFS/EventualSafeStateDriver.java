package graph.eventualSafeStateBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStateDriver {

}


class Solution {
  public List<Integer> eventualSafeNodes(int[][] graph) {

    List<List<Integer>> reverseGraph = new ArrayList<>();
    int n = graph.length;
    for (int i = 0; i < n; i++) {
      reverseGraph.add(new ArrayList<>());
    }
    int[] indegree = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < graph[i].length; j++) {


        reverseGraph.get(graph[i][j]).add(i);
        indegree[i]++;
      }
    }
    List<Integer> result = new ArrayList<>();
    boolean[] safeNode = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      if(indegree[i] == 0){
        queue.offer(i);
        safeNode[i] = true;
      }
    }

    while (!queue.isEmpty()){

      int curr = queue.poll();
      for (int i = 0; i < reverseGraph.get(curr).size(); i++) {
        int next = reverseGraph.get(curr).get(i);
        indegree[next]--;
        if(indegree[next] == 0){
          queue.offer(next);
          safeNode[next] = true;
        }
      }

    }

    for (int i = 0; i < n; i++) {
      if(safeNode[i]){
        result.add(i);
      }
    }
    return result;

  }
}
