package BinaryTree.verticalTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class VerticalTraversalDriver {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(3);

    root.left = new TreeNode(9);
    root.right = new TreeNode(20);

    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(new Solution().verticalTraversal(root));
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
  public List<List<Integer>> verticalTraversal(TreeNode root) {

    Map<Integer,Map<Integer,List<Integer>>> listMap = new TreeMap<>();
    verticalTraversal(root,listMap,0,0);

    List<List<Integer>> result = new ArrayList<>();

    for (Map.Entry<Integer,Map<Integer,List<Integer>>> innerMap : listMap.entrySet()){

      List<Integer> temp = new ArrayList<>();

      for (Map.Entry<Integer,List<Integer>> keyValue: innerMap.getValue().entrySet()){

        if(keyValue.getValue().size() > 1){
          Collections.sort(keyValue.getValue());
        }
        temp.addAll(keyValue.getValue());
      }

      result.add(temp);


    }
    return result;


  }

  public void verticalTraversal(TreeNode root,Map<Integer,Map<Integer,List<Integer>>> listMap,int row, int col) {


    if(root == null){
      return;
    }

    Map<Integer,List<Integer>> innerMap = listMap.getOrDefault(col,new TreeMap<>());
    List<Integer> list = innerMap.getOrDefault(row,new ArrayList<>());
    list.add(root.val);
    innerMap.put(row,list);
    listMap.put(col,innerMap);
    verticalTraversal(root.left,listMap,row+1,col-1);
    verticalTraversal(root.right,listMap,row+1,col+1);

  }
}
