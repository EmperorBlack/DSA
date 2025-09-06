package linkedList.flaternLL;

import java.util.List;

public class FlaternLLDriver {

  public static void main(String[] args) {

  }
}


class Node {
  public int val;
  public Node prev;
  public Node next;
  public Node child;
};

class Solution {
  public Node flatten(Node head) {

    flattenLL(head);
    return head;


  }

  public Node flattenLL(Node head) {

    Node tail = null;
    Node pre = null;
    while (head != null) {
      if (head.child != null) {
        Node nextFlat = head.next;
        tail = flattenLL(head.child);
        pre = tail;
        head.next = head.child;
        head.child.prev = head;
        head.child = null;
        tail.next = nextFlat;
        if(nextFlat != null)
          nextFlat.prev = tail;
        head = nextFlat;
      } else {
        pre = head;
        head = head.next;
      }
    }

    return pre;
  }
}