package BinaryTree.boundrayTraversal;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalDriver {

//  28 -1 4 42 40 39 2 24 41 -1 -1 -1 -1 -1 17 15 37 45 18 -1 33 43 35 -1 -1 23 -1 -1 -1 -1 -1 -1 30 12 -1 -1 -1 -1 47 7 -1 -1 32 -1 -1


  public static void main(String[] args) {

    TreeNode root = new TreeNode(10);
//    root.left = new TreeNode(5);
    root.right = new TreeNode(20);

//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(8);

    root.right.left = new TreeNode(18);
    root.right.right = new TreeNode(25);

    root.right.right.left = new TreeNode(29);
    root.right.right.left.right = new TreeNode(30);

//    root.left.right.left = new TreeNode(7);

    System.out.println(Solution.traverseBoundary(root));

  }
}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class Solution {
  public static List<Integer> traverseBoundary(TreeNode root){
    List<Integer> result = new ArrayList<>();

    if(root==null){
      return result;
    }
    result.add(root.data);
    traverseLeftBoundary(root.left,result);
    traverseLeafBoundary(root.left,result);
    traverseLeafBoundary(root.right,result);
    traverseRightBoundary(root.right,result);
    return result;
  }

  public static void traverseLeftBoundary(TreeNode root,List<Integer> left){
    // Write your code here.

    if(root == null || (root.left ==null && root.right == null)){
      return ;
    }

    left.add(root.data);
    if(root.left != null){
      traverseLeftBoundary(root.left,left);
    }else{
      traverseLeftBoundary(root.right,left);
    }
  }

  public static void traverseLeafBoundary(TreeNode root,List<Integer> leaf){
    // Write your code here.

    if(root == null ){
      return ;
    }

    if(root.left == null && root.right == null){
      leaf.add(root.data);
    }

    traverseLeafBoundary(root.left,leaf);
    traverseLeafBoundary(root.right,leaf);
  }

  public static void traverseRightBoundary(TreeNode root,List<Integer> right){
    // Write your code here.

    if(root == null || (root.left ==null && root.right == null)){
      return ;
    }

    if(root.right != null){
      traverseRightBoundary(root.right,right);
    }else {
      traverseRightBoundary(root.left,right);
    }
    right.add(root.data);
  }

}