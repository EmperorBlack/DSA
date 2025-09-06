package google.closestNodeMax;

import java.util.Arrays;

public class ClosestNodeDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().closestMeetingNode(new int[]{2,2,3,-1},0,1));
  }
}
class Solution {
  public int closestMeetingNode(int[] edges, int node1, int node2) {

    int[] node1Dist = new int[edges.length];

    int[] node2Dist = new int[edges.length];

    Arrays.fill(node1Dist, Integer.MAX_VALUE);
    Arrays.fill(node2Dist, Integer.MAX_VALUE);

    dfs(node1,node1Dist,edges,0);
    dfs(node2,node2Dist,edges,0);

    int max = Integer.MAX_VALUE;
    int maxNode = -1;
    for(int i =0;i< node1Dist.length;i++){

      int currMax = Math.max(node1Dist[i],node2Dist[i]);
      if(currMax < max){
        maxNode = i;
        max = currMax;
      }
    }
    return maxNode;

  }

  private void dfs(int curr, int dist[], int[] edges, int currDist) {

    dist[curr] = currDist;

    int next = edges[curr];
    if(next != -1 && dist[next] > currDist+1){
      dfs(next,dist,edges,currDist+1);
    }

  }
}
