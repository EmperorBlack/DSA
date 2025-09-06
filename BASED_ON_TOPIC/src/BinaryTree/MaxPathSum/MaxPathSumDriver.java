package BinaryTree.MaxPathSum;

public class MaxPathSumDriver {

  public static void main(String[] args) {


    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);

    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);

    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);

    System.out.println(new Solution().maxPathSum(root));
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

class Pair{
  int pathSum;
  int maxSum;

  public Pair(int pathSum, int maxSum) {
    this.pathSum = pathSum;
    this.maxSum = maxSum;
  }
}

class Solution {
  public int maxPathSum(TreeNode root) {
    return maxPathHelp(root).maxSum;
  }

  public Pair maxPathHelp(TreeNode root){

    if(root == null){
      return new Pair(0,Integer.MIN_VALUE);
    }

    Pair left = maxPathHelp(root.left);
    Pair right = maxPathHelp(root.right);

    int currSum = left.pathSum+root.val+ right.pathSum;

    int pathMax = Math.max(left.pathSum,right.pathSum);

    if(pathMax != Integer.MIN_VALUE){
      pathMax = pathMax+root.val;
    }else {
      pathMax = root.val;
    }
    int maxPathSumIs = Math.max(Math.max(currSum,left.maxSum),right.maxSum);
    return new Pair(Math.max(pathMax, 0), maxPathSumIs);

  }
}