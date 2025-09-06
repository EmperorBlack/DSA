package BinaryTree.countCompleteTreeNode;

public class CountCompleteTreeNodeDriver {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right.left = new TreeNode(6);

    System.out.println(new Solution().countNodes(root));

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
  public int countNodes(TreeNode root) {

    return countNodesHelp(root);
  }

  private int countNodesHelp(TreeNode node){

    if(node == null){
      return 0;
    }

    TreeNode left = node.left;
    TreeNode right = node.right;
    int h = 1;
   while(left!=null && right!=null){
     left = left.left;
     right=right.right;
     h++;
   }

   if(left == null && right == null){
     return (int)Math.pow(2,h)-1;
   }else {
     return 1+countNodesHelp(node.left)+countNodesHelp(node.right);
   }
  }
}
