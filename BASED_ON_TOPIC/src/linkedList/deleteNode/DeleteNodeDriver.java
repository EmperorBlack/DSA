package linkedList.deleteNode;


public class DeleteNodeDriver {

  public static void main(String[] args) {

  }
}


class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {

  public void deleteNode(ListNode node) {

    ListNode temp = node.next;
    while(temp != null){
      node.val = temp.val;
      node = node.next;
      temp = temp.next;
    }

    node.next = null;

  }
}