package BinaryTree.burnATree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurnATreeDriver {

  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.left.right.left = new Node(7);
    root.left.right.right = new Node(8);

    root.right.right = new Node(6);
    root.right.right.right = new Node(9);
    root.right.right.right.right = new Node(10);

    System.out.println(Solution.minTime(root,8));


  }
}
class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {


  public static int minTime(Node root, int target) {
      if (root == null){
        return 0;
      }

      Node targetNode = search(root,target);
      if(targetNode == null){
        return 0;
      }
      Queue<Node> queue = new ArrayDeque<>();
      Map<Integer,Node> map = new HashMap<>();
      trackParent(root,map);
      Set<Integer> visited = new HashSet<>();
      visited.add(targetNode.data);
      queue.offer(targetNode);

      int count = 0;
      while (!queue.isEmpty()){
        count++;
        int size = queue.size();
        for (int i = 0; i < size; i++) {

          Node curr = queue.poll();

          if(curr.left!=null && !visited.contains(curr.left.data)){
            queue.offer(curr.left);
            visited.add(curr.left.data);
          }

          if(curr.right!=null && !visited.contains(curr.right.data)){
            queue.offer(curr.right);
            visited.add(curr.right.data);
          }

          if(map.containsKey(curr.data) && !visited.contains(map.get(curr.data).data)){
            queue.offer(map.get(curr.data));
            visited.add(map.get(curr.data).data);
          }
        }
      }

return count-1;
  }

  private static void trackParent(Node root, Map<Integer,Node> map){

      if(root == null){
        return;
      }

      if(root.left != null){
        map.put(root.left.data,root);
      }
      if(root.right != null){
        map.put(root.right.data, root);
      }

      trackParent(root.left,map);
      trackParent(root.right,map);


  }


  private static Node search(Node root, int target){

      if(root == null){
        return null;
      }

      if(root.data == target){
        return root;
      }

      Node left = search(root.left,target);
      Node right = null;
      if(left == null){
        right = search(root.right,target);
      }
      return left == null ? right : left;
  }


}