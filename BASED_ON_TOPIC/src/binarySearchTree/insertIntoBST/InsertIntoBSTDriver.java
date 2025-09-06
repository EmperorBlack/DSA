package binarySearchTree.insertIntoBST;


public class InsertIntoBSTDriver {

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

  TreeNode ceil = null;
  public TreeNode insertIntoBST(TreeNode root, int val) {

    find(root,val);
    TreeNode newNode = new TreeNode(val);
    if(ceil == null){
      newNode.right = root;
      return newNode;
    }
    newNode.right = ceil.right;
    ceil.right = newNode;
    return root;

  }

  private void find(TreeNode root,int key){
    if(root == null){
      return;
    }

    if(root.val > key){
      find(root.left,key);
    }else{
      ceil = root;
      find(root.right, key);
    }

  }
}
