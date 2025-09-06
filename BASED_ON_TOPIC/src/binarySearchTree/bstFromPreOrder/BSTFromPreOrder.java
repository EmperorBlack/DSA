package binarySearchTree.bstFromPreOrder;

public class BSTFromPreOrder {

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
  static int index = 0;
  public TreeNode bstFromPreorder(int[] preorder) {

    index =0;
    return bstPre(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
  }

  private TreeNode bstPre(int[] preorder, int leftBound, int rightBound){

    if(index >= preorder.length){
      return null;
    }

    if(preorder[index] < leftBound || preorder[index] > rightBound){
      return null;
    }

    TreeNode root = new TreeNode(preorder[index]);
    index++;
    root.left = bstPre(preorder,leftBound,root.val);
    root.right = bstPre(preorder, root.val, rightBound);
    return root;

  }
}
