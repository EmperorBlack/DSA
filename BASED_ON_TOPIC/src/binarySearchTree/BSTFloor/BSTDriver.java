package binarySearchTree.BSTFloor;

public class BSTDriver {

  public static void main(String[] args) {

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

class Tree {
  int floor = Integer.MIN_VALUE;
  // Function to return the ceil of given number in BST.
  int findCeil(Node root, int key) {
    if (root == null) return -1;
    // Code here
    find(root,key);
    if(floor == Integer.MIN_VALUE){
      return -1;
    }
    return floor;
  }

  void find(Node root,int key){
    if(root == null){
      return;
    }

    if(root.data < key){
      find(root.right,key);
    }else{
      floor = root.data;
      find(root.left, key);
    }

  }
}

class Solution {
  static int ceil = Integer.MAX_VALUE;
  public static int floor(Node root, int x) {
    // Code here
    ceil = Integer.MAX_VALUE;
    if (root == null) return -1;
    // Code here
    find(root,x);
    if(ceil == Integer.MAX_VALUE){
      return -1;
    }
    return ceil;
  }


  static void find(Node root,int key){
    if(root == null){
      return;
    }

    if(root.data > key){
      find(root.left,key);
    }else{
      ceil = root.data;
      find(root.right, key);
    }

  }
}
