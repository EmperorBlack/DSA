package BinaryTree.postOrderToTree;

import java.util.HashMap;
import java.util.Map;

public class postOrderDriver {

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
  public TreeNode buildTree(int[] inorder,int[] postorder) {

    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i],i);
    }

    int len = postorder.length-1;
    return build(postorder,0,len,inorder,0,len,map);

  }

  private TreeNode build(int[] post,int poStart, int poEnd, int[] in, int inStart, int inEnd, Map<Integer,Integer> map){

    if(inStart > inEnd){
      return null;
    }

    TreeNode root = new TreeNode(post[poEnd]);

    int inMid = map.get(post[poEnd]);
    int right = inEnd-inMid;

    root.left = build(post,poStart,poEnd-1-right, in, inStart,inMid-1,map);
    root.right = build(post,poEnd-right,poEnd-1, in, inMid+1,inEnd,map);

    return root;
  }

}
