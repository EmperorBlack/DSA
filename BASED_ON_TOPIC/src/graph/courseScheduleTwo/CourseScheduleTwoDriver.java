package graph.courseScheduleTwo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleTwoDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    List<List<Integer>> graph = new ArrayList<>();
    int[] indegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
      indegree[prerequisites[i][0]]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < indegree.length; i++) {
      if(indegree[i] == 0){
        queue.offer(i);
      }
    }

    int[] result = new int[numCourses];
    int index =0;
    while (!queue.isEmpty()){

      int curr = queue.poll();
      result[index++] = curr;

      for (int i = 0; i < graph.get(curr).size(); i++) {
        int next = graph.get(curr).get(i);
        indegree[next]--;
        if(indegree[next] == 0){
          queue.offer(next);
        }
      }

    }

    if(index == numCourses){
      return result;
    } else {
      return new int[]{};
    }



  }
}