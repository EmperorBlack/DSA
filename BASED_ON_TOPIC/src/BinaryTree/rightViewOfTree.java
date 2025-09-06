package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class rightViewOfTree {

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
//  int lastLevel =-1;
  public List<Integer> rightSideView(TreeNode root) {

    List<Integer> list = new ArrayList<>();
    rightSideView(root,list,0);
    return list;
  }

  public void rightSideView(TreeNode root,List<Integer> result, int level) {

    if(root == null){
      return;
    }
    if(level > result.size()){
      result.add(root.val);
    }

    rightSideView(root.left, result, level+1);
    rightSideView(root.right, result, level+1);
  }
}