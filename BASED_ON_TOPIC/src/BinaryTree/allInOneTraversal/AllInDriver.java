package BinaryTree.allInOneTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AllInDriver {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right.right = new TreeNode(7);

    System.out.println(Solution.preInPostTraversal(root));
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

class Solution{

  static class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public static List<List<Integer>> preInPostTraversal(TreeNode root){

    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root,1));

    while (!stack.isEmpty()){

      Pair pair = stack.pop();
      TreeNode node = pair.node;
      int level = pair.level;

      if(level == 1){
        pre.add(node.data);
        stack.push(new Pair(node,2));
        if(node.left != null){
          stack.push(new Pair(node.left,1));
        }
      } else if (level == 2) {
        in.add(node.data);
        stack.push(new Pair(node,3));
        if(node.right != null){
          stack.push(new Pair(node.right,1));
        }
      }else {
        post.add(node.data);
      }
    }
    return Arrays.asList(pre,in,post);

  }
}
