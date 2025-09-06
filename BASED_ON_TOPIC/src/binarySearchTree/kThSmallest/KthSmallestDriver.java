package binarySearchTree.kThSmallest;

public class KthSmallestDriver {

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

  int  deltaK = 1;
  int result = -1;
  public int kthSmallest(TreeNode root, int k) {

    kthSmallestHelp(root,k);
    return result;
  }

  private  void kthSmallestHelp(TreeNode root, int k) {

    if(root == null || deltaK > k){
      return;
    }
    kthSmallestHelp(root.left,k);
    if(deltaK == k){
      result = root.val;
    }
    deltaK++;
    kthSmallestHelp(root.right,k);
  }
}
