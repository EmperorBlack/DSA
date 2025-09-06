package BinaryTree.traversalIterative;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalDriver {

}

class TreeNode {
  int val;
 TreeNode left;
TreeNode right;
  TreeNode() {
    this.val = 0;
    this.left = null;
    this.right = null;
  }
  TreeNode(int data) {
    this.val = data;
    this.left = null;
    this.right = null;
  }
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.val = data;
    this.left = left;
    this.right = right;
  }
};

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    List<Integer> list = new ArrayList<>();
    if(root == null){
      return list;
    }
    while (!stack.isEmpty()){
      TreeNode temp = stack.pop();
      list.add(temp.val);

      if(temp.right != null){
        stack.push(temp.right);
      }

      if (temp.left != null){
        stack.push(temp.left);
      }
    }
    return list;
  }

}

class Solution_in {
  public List<Integer> inorderTraversal(TreeNode root) {

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    List<Integer> list = new ArrayList<>();
    if(root == null){
      return list;
    }

    while (root!= null || !stack.isEmpty()){

      while (root!=null){
        stack.push(root);;
        root=root.left;
      }
      TreeNode temp = stack.pop();
      list.add(temp.val);
      root = temp.right;
    }
    return list;


  }
}

class Solution_post {
  public List<Integer> postorderTraversal(TreeNode root) {

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    stack1.push(root);

    while (!stack1.isEmpty()){

      TreeNode temp = stack1.pop();
      stack2.push(temp.val);

      if(temp.left != null){
        stack1.push(temp.left);
      }

      if(temp.right != null){
        stack1.push(temp.right);
      }

    }

    List<Integer> list = new ArrayList<>();
    while (!stack2.isEmpty()){
      list.add(stack2.pop());
    }
    return list;

  }
}

class Solution_post_singleStack {
  public List<Integer> postorderTraversal(TreeNode root) {

    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();

    TreeNode curr = root;

    while (curr!=null || !stack.isEmpty()){

      if(curr!=null){
        stack.push(curr);
        curr = curr.left;
      }else{
        TreeNode temp = stack.peek().right;
        if(temp == null){
          temp = stack.pop();
          result.add(temp.val);
          while (!stack.isEmpty() && stack.peek().right == temp){
            temp = stack.pop();
            result.add(temp.val);
          }
        }else{
          curr = temp;
        }
      }


    }


    return result;

  }

}

class Solution_level {
  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    preOrderWithLevel(root,0,result);
    return result;

  }

  public void preOrderWithLevel(TreeNode root, int level,List<List<Integer>> result){

    if(root == null){
      return;
    }


    if(level >= result.size()){
      List<Integer> list = new ArrayList<>();
      list.add(root.val);
      result.add(list);
    }else{
      List<Integer> list = result.get(level);
      list.add(root.val);
    }

    preOrderWithLevel(root.left,level+1,result);
    preOrderWithLevel(root.right,level+1,result);



  }
}

