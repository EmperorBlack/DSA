package binarySearchTree.twoSum;

import java.util.Stack;

public class TwoSumDriver {

  public static void main(String[] args) {

  }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left,TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class BSTIterator{


  Stack<TreeNode> leftStack = null;
  Stack<TreeNode> rightStack = null;

  public BSTIterator(TreeNode root) {
    leftStack = new Stack<>();
    rightStack = new Stack<>();
    pushAllLeft(root);
    pushAllRight(root);
  }

  public TreeNode getLeft(){
    TreeNode root = leftStack.pop();
    pushAllLeft(root.right);
    return root;
  }

  public TreeNode getRight(){
    TreeNode root = rightStack.pop();
    pushAllRight(root.left);
    return root;
  }

  private void pushAllLeft(TreeNode root){
    while (root!=null){
      leftStack.push(root);
      root=root.left;
    }
  }

  private void pushAllRight(TreeNode root){
    while (root!=null){
      rightStack.push(root);
      root=root.right;
    }
  }
}

class Solution {
  public boolean findTarget(TreeNode root, int k) {

    BSTIterator iterator = new BSTIterator(root);
    TreeNode left = iterator.getLeft();
    TreeNode right = iterator.getRight();

    while (left!=right){
      if((left.val+ right.val) == k){
        return true;
      } else if ((left.val+ right.val) > k) {
        right = iterator.getRight();
      }else {
        left =iterator.getLeft();
      }
    }
    return false;

  }
}