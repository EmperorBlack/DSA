package BinaryTree.rootToLeaf;

import java.util.ArrayList;

public class RootToLeafDriver {

}
class Node
{
  int data;
  Node left;
  Node right;

  Node(int data)
  {
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {
  public static ArrayList<ArrayList<Integer>> Paths(Node root) {
    // code here

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Paths(root,result,new ArrayList<>());
    return result;

  }

  public static void Paths(Node root,ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {

    if(root == null){
      return;
    }
    path.add(root.data);

    if(root.left == null && root.right == null){
      result.add(new ArrayList<>(path));
      path.remove(path.size()-1);
      return;
    }

    Paths(root.left,result,path);
    Paths(root.right,result,path);
    path.remove(path.size()-1);
  }
}
