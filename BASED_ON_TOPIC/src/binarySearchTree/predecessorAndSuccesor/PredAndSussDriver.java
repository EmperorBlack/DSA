package binarySearchTree.predecessorAndSuccesor;

public class PredAndSussDriver {

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

class Solution {
  static Node preV = null;
  static Node sus = null;
  public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
    // code here.
    // update pre[0] with the predecessor of the key
    // update suc[0] with the successor of the key
    preV = null;
    sus = null;
    predesser(root,key-1);
    sussesor(root,key+1);
    pre[0] = preV;
    suc[0] = sus;
  }

  private static void predesser(Node root,int key){

    if(root == null){
      return;
    }

    if(root.data > key ){
      predesser(root.left,key);
    }else{
      preV = root;
      predesser(root.right,key);
    }
  }

  private static void sussesor(Node root,int key){

    if(root == null){
      return;
    }

    if(root.data >= key ){
      sus = root;
      sussesor(root.left,key);
    }else{
      sussesor(root.right,key);
    }
  }
}
