package BinaryTree.createTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CreateTreeDriver {

}
class Node{
  int val;
  Node left;
  Node right;

  Node(int val){
    this.val=val;
    left=null;
    right=null;
  }
}


class Solution{
  public static void createTree(Node root0, ArrayList<Integer> v ){
    // Code here

    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root0);
    for(int i =1;i<v.size();i=i+2){

      Node curr = queue.poll();
      curr.left = new Node(v.get(i));
      curr.right = new Node(v.get(i+1));

      queue.offer(curr.left);
      queue.offer(curr.right);
    }
  }
}

//without extra space
class Solution_1{
  public static void createTree(Node root0, ArrayList<Integer> v ){
    // Code here

    createNode(root0,0,v);
  }

  public static Node createNode(Node root, int index, ArrayList<Integer> v) {

    if(index >= v.size()) {
    return null;
    }
    if(root == null){
      root = new Node(v.get(index));
    }

    root.left = createNode(null,2*index+1,v);
    root.right = createNode(null,2*index+2,v);
    return root;
  }

}