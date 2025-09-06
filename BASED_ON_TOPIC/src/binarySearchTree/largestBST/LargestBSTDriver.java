package binarySearchTree.largestBST;

import java.util.ArrayList;

public class LargestBSTDriver {

  public static void main(String[] args) {


    Node root = new Node(1);
    root.left = new Node(4);
    root.right = new Node(4);

    root.left.left = new Node(6);
    root.left.right = new Node(8);

    System.out.println(Solution_2.largestBst(root));
  }
}

 class Node  
 { 
     int data; 
     Node left, right; 

     public Node(int d)  
     { 
         data = d; 
         left = right = null; 
     } 
 }

 class MinMax{
  int min;
  int max;
  int count;

   public MinMax(int min, int max,int count) {
     this.min = min;
     this.max = max;
     this.count = count;
   }
 }

class Solution{

  static int count = Integer.MIN_VALUE;
  static int largestBst(Node root)
  {

    count = Integer.MIN_VALUE;
    largeBST(root);
    return count;
  }

  static MinMax largeBST(Node root){
    if(root == null){
      return new MinMax(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
    }


    MinMax left = largeBST(root.left);
    MinMax right = largeBST(root.right);

    if(left.count ==-1 || right.count==-1){
      return new MinMax(Integer.MAX_VALUE,Integer.MIN_VALUE,-1);
    }
    if(root.data < right.min && root.data > left.max){
      MinMax rotMinMax = new MinMax(Math.min(left.min, root.data), Math.max(root.data, right.max), left.count+right.count+1);
      count = Math.max(rotMinMax.count,count);
      return rotMinMax;
    }else{
      MinMax rotMinMax = new MinMax(Math.min(left.min, root.data), Math.max(root.data, right.max), -1);
      return rotMinMax;
    }

  }

}

//Striver
class Solution_2{

  static int largestBst(Node root)
  {
    return largeBST(root).count;
  }

  static MinMax largeBST(Node root){
    if(root == null){
      return new MinMax(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
    }


    MinMax left = largeBST(root.left);
    MinMax right = largeBST(root.right);

    if(root.data < right.min && root.data > left.max) {
      return new MinMax(Math.min(left.min, root.data), Math.max(root.data, right.max),
          left.count + right.count + 1);
    }
      return new MinMax(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.count, right.count));



  }

}
