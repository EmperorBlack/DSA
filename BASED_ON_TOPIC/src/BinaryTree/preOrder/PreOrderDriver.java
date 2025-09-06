package BinaryTree.preOrder;

import java.util.HashMap;
import java.util.Map;

public class PreOrderDriver {

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
  public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i],i);
    }

    int len = preorder.length-1;
    return build(preorder,0,len,inorder,0,len,map);

  }

  private TreeNode build(int[] pre,int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer,Integer> map){

    if(inStart > inEnd){
      return null;
    }

    TreeNode root = new TreeNode(pre[preStart]);

    int inMid = map.get(pre[preStart]);
    int left = inMid-inStart;

    root.left = build(pre,preStart+1,preStart+left, in, inStart,inMid-1,map);
    root.right = build(pre,preStart+1+left,preEnd, in, inMid+1,inEnd,map);

    return root;
  }

}
