package BinaryTree.maxWidthOfBT;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthOfBinaryTreeDriver {

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
  int maxWidth = Integer.MIN_VALUE;
  public int widthOfBinaryTree(TreeNode root) {


    widthOfBt(root,0,0,new HashMap<>());
    return maxWidth;

  }

  private void widthOfBt(TreeNode root, int dist,int level, Map<Integer,Integer> map){

    if(root == null){
      return;
    }

    if(!map.containsKey(level)){
      map.put(level,dist);
    }

    maxWidth = Math.max(maxWidth,(dist-map.get(level))+1);
    widthOfBt(root.left,2*dist,level+1,map);
    widthOfBt(root.right,2*dist+1,level+1,map);

  }
}