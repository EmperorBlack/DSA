package BinaryTree.flaternBTToLL;

public class FlaternBTToLL {

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
  static TreeNode pre = null;
  public void flatten(TreeNode root) {
    flat(root);
  }

  private void flat(TreeNode root){
    if(root == null)
    {
      return;
    }
    flat(root.right);
    flat(root.left);
    root.right = pre;
    pre = root;
    pre.left = null;
  }

}