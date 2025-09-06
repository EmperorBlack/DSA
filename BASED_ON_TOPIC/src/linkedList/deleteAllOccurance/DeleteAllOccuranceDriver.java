package linkedList.deleteAllOccurance;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteAllOccuranceDriver {

}

class Node {

  int data;
  Node next;
  Node prev;

  Node(int data) {
    this.data = data;
    next = prev = null;
  }
}


class Solution {
  static Node deleteAllOccurOfX(Node head, int x) {


    Node root = head;
    while (head != null){

      if(head.data == x){

        Node left = head.prev;
        Node right = head.next;
        head = head.next;
        if(left != null && right!= null){
          left.next = right;
          right.prev = left;
        } else if(left == null){
          root = right;
          right.prev = null;
        } else{
          left.next = null;
        }
      }else{
        head = head.next;
      }

    }
    return root;
  }
}

//two sum
class Solution2 {
  public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
    // code here

    Node left = head;
    Node right = head;

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    while(right.next!= null){
      right = right.next;
    }

    while(left.data < right.data){

      if((left.data + right.data) == target){
        result.add(new ArrayList<>(Arrays.asList(left.data ,right.data)));
        left = left.next;
        right = right.prev;
      } else if ((left.data + right.data) < target) {
        left = left.next;

      }else{
        right = right.prev;
      }
    }
    return result;


  }
}