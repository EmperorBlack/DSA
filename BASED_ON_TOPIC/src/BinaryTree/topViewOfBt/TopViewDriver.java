package BinaryTree.topViewOfBt;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewDriver {


  public static void main(String[] args) {

    Node root = new Node(3);

    root.left = new Node(9);
    root.right = new Node(20);

    root.right.left = new Node(15);
    root.right.right = new Node(7);

    System.out.println(Solution.topView(root));
  }
}
class Node{
  int data;
  Node left;
  Node right;
  Node(int data){
    this.data = data;
    left=null;
    right=null;
  }
}

class Pair{
  Node node;
  int line;

  public Pair(Node node, int line) {
    this.node = node;
    this.line = line;
  }
}
class Solution {
  // Function to return a list of nodes visible from the top view
  // from left to right in Binary Tree.
  static ArrayList<Integer> topView(Node root) {
    // code here

    ArrayList<Integer> result = new ArrayList<>();
    if(root == null){
      return result;
    }

    Queue<Pair> queue = new ArrayDeque<>();
    Map<Integer,Integer> map = new TreeMap<>();

    queue.offer(new Pair(root,0));

    while (!queue.isEmpty()){

      Pair p = queue.poll();
      if(!map.containsKey(p.line)){
        map.put(p.line,p.node.data);
      }

      if(p.node.left!= null){
        queue.offer(new Pair(p.node.left,p.line-1));
      }
      if(p.node.right!= null){
        queue.offer(new Pair(p.node.right,p.line+1));
      }

    }

    for (Map.Entry<Integer,Integer> keyValue : map.entrySet()){
      result.add(keyValue.getValue());
    }
    return result;
  }
}