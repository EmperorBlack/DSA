package BinaryTree.childrenSumBt;

public class ChildreanSumBtDriver {

}
class Node{
  int data;
  Node left,right;

  Node(int key)
  {
    data = key;
    left = right = null;
  }
}
class Solution
{
  //Function to check whether all nodes of a tree have the value
  //equal to the sum of their child nodes.
  public static int isSumProperty(Node root)
  {
    int val = isSumPropertyHelp(root);
    if(val > -1){
      return 1;
    }
    return 0;

  }

  public static int isSumPropertyHelp(Node root)
  {

    if(root.left == null && root.right == null){
      return root.data;
    }

    int left = 0,right=0;
    if(root.left != null){
     left =  isSumPropertyHelp(root.left);
    }
    if(root.right != null){
      right = isSumPropertyHelp(root.right);
    }

    if(left ==-1 || right == -1){
      return -1;
    }

    if(root.data == left+right){
      return root.data;
    }else{
      return -1;
    }

  }


}
