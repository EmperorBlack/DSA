package graph.primsAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgoDriver {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    // Each inner list is of the form [u, v, w]
    edges.add(new ArrayList<Integer>() {{ add(1); add(2); add(2); }});
    edges.add(new ArrayList<Integer>() {{ add(1); add(4); add(6); }});
    edges.add(new ArrayList<Integer>() {{ add(2); add(1); add(2); }});
    edges.add(new ArrayList<Integer>() {{ add(2); add(3); add(3); }});
    edges.add(new ArrayList<Integer>() {{ add(2); add(4); add(8); }});
    edges.add(new ArrayList<Integer>() {{ add(2); add(5); add(5); }});
    edges.add(new ArrayList<Integer>() {{ add(3); add(2); add(3); }});
    edges.add(new ArrayList<Integer>() {{ add(3); add(5); add(7); }});
    edges.add(new ArrayList<Integer>() {{ add(4); add(1); add(6); }});
    edges.add(new ArrayList<Integer>() {{ add(4); add(2); add(8); }});
    edges.add(new ArrayList<Integer>() {{ add(4); add(5); add(9); }});
    edges.add(new ArrayList<Integer>() {{ add(5); add(2); add(5); }});
    edges.add(new ArrayList<Integer>() {{ add(5); add(3); add(7); }});
    edges.add(new ArrayList<Integer>() {{ add(5); add(4); add(9); }});

    System.out.println(Solution.calculatePrimsMST(5,14,edges));
  }
}

class Tuple{
  int node;
  int parent;
  int weight;

  public Tuple(int node, int parent, int weight) {
    this.node = node;
    this.parent = parent;
    this.weight = weight;
  }
}

class Edge {
  int node;
  int weight;

  public Edge(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }
}

class Solution
{
  public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
  {
    // Write your code here.

    List<List<Edge>> graph = new ArrayList<>();

    for (int i = 0; i < n+1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int src = g.get(i).get(0);
      int dst = g.get(i).get(1);
      int weight = g.get(i).get(2);

      graph.get(src).add(new Edge(dst,weight));
      graph.get(dst).add(new Edge(src,weight));
    }

    Queue<Tuple> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p1.weight,p2.weight));

    queue.offer(new Tuple(1,-1,0));
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    boolean[] visited = new boolean[n+1];

    int count = 0;
    while (!queue.isEmpty() && count != n ){

      Tuple curr = queue.poll();
      if(visited[curr.node]){
        continue;
      }
      visited[curr.node] = true;
      count++;
      if(curr.parent!=-1){
        result.add(new ArrayList<>(Arrays.asList(curr.parent,curr.node,curr.weight)));
      }

      for (int i = 0; i < graph.get(curr.node).size(); i++) {

        Edge next = graph.get(curr.node).get(i);
        if(!visited[next.node]){
          queue.offer(new Tuple(next.node,curr.node,next.weight));
        }
      }

    }

    return result;

  }
}