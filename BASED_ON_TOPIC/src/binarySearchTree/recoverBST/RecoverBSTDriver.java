package binarySearchTree.recoverBST;

public class RecoverBSTDriver {

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
  TreeNode first=null,second=null,third = null;
  TreeNode pre = new TreeNode(Integer.MIN_VALUE);
  public void recoverTree(TreeNode root) {

    markFaultNode(root);
    if(third == null){
      first.val = first.val ^ second.val;
      second.val = first.val ^ second.val;
      first.val = first.val ^ second.val;
    }else{
      first.val = first.val ^ third.val;
      third.val = first.val ^ third.val;
      first.val = first.val ^ third.val;
    }
  }

  private void markFaultNode(TreeNode root){

    if(root ==null){
      return;
    }

    markFaultNode(root.left);
    if(pre.val > root.val){
      if(first == null){
        first = pre;
        second=root;
      }else{
        third= root;
      }
    }else {
      pre = root;
    }
    markFaultNode(root.right);
  }
}
