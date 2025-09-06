package binarySearchTree.validBST;

public class ValidBSTDriver {

  public static void main(String[] args) {

  }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
  public boolean isValidBST(TreeNode root) {

    return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
  }

  private boolean isValid(TreeNode root, long leftBound, long rightBound){

    if(root == null){
      return true;
    }

    if(root.val < leftBound || root.val > rightBound){
      return false;
    }

    return isValid(root.left,leftBound,root.val) && isValid(root.right, root.val, rightBound);

  }
}
