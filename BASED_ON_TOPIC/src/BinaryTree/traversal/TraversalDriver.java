package BinaryTree.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraversalDriver {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(4);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(6);

    System.out.println(Solution.getTreeTraversal(root));

  }
}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode() {
    this.data = 0;
    this.left = null;
    this.right = null;
  }
  TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
};

class Solution {
  public static List<List<Integer>> getTreeTraversal(TreeNode root) {
    // Write your code here.
    List<Integer> in = new ArrayList<>();
    inOrder(root,in);
    List<Integer> pre = new ArrayList<>();
    preOrder(root,pre);
    List<Integer> post = new ArrayList<>();
    postOrder(root,post);
    return Arrays.asList(in,pre,post);
  }

  public static void preOrder(TreeNode root, List<Integer> list){
    if(root == null){
      return;
    }

    list.add(root.data);
    preOrder(root.left,list);
    preOrder(root.right,list);
  }

  public static void inOrder(TreeNode root, List<Integer> list){
    if(root == null){
      return;
    }
    inOrder(root.left,list);
    list.add(root.data);
    inOrder(root.right,list);
  }

  public static void postOrder(TreeNode root, List<Integer> list){
    if(root == null){
      return;
    }
    postOrder(root.left,list);
    postOrder(root.right,list);
    list.add(root.data);
  }
}
