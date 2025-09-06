package BinaryTree.bottomView;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewDriver {

}
class Node
{
  int data; //data of the node
  int hd; //horizontal distance of the node
  Node left, right; //left and right references

  // Constructor of tree node
  public Node(int key)
  {
    data = key;
    hd = Integer.MAX_VALUE;
    left = right = null;
  }
}

class Pair{
  int level;
  int value;

  public Pair(int level, int value) {
    this.level = level;
    this.value = value;
  }
}

class Solution
{
  //Function to return a list containing the bottom view of the given tree.
  public ArrayList<Integer> bottomView(Node root)
  {
    Map<Integer,Pair> map = new TreeMap<>();
    bottomView(root,map,0,0);
    ArrayList<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer,Pair> kv : map.entrySet()){
      list.add(kv.getValue().value);

    }
    return list;
  }

  private  void bottomView(Node root,Map<Integer,Pair> map, int distance, int level){

    if (root == null) {
      return;
    }

    if(!map.containsKey(distance)){
      map.put(distance,new Pair(level, root.data));
    }else{
      if(map.get(distance).level <= level){
        map.put(distance,new Pair(level,root.data));
      }
    }
    bottomView(root.left,map,distance-1,level+1);
    bottomView(root.right,map,distance+1,level+1);
  }
}