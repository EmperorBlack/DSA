package BinaryTree.LCA;

public class LCADriver {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);

    System.out.println(new Solution().lowestCommonAncestor(root,root.left,root.right));
  }
}

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

class Solution {

  TreeNode result = null;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    lowestCommonAncestorHelp(root,p,q);
    return result;
  }

  public int lowestCommonAncestorHelp(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null){
      return 0;
    }
    int count =0;
    if(root.val == p.val || q.val == root.val){
      count++;
    }

    int left = lowestCommonAncestorHelp(root.left,p,q);
    int right = lowestCommonAncestorHelp(root.right,p,q);

    count = count+left+right;

    if(result==null && count >= 2){
      result = root;
    }
    return count;

  }
}
