package linkedList.copyRandomPointer;

public class CopyrandomPointerDriver {

  public static void main(String[] args) {

    Node node7 = new Node(7);
    Node node13 = new Node(13);
    Node node11 = new Node(11);
    Node node10 = new Node(10);
    Node node1 = new Node(1);

    node7.next = node13;
    node13.next = node11;
    node11.next = node10;
    node10.next = node1;

    node13.random = node7;
    node11.random = node1;
    node10.random = node11;
    node1.random = node7;

    Node root = new Solution().copyRandomList(node7);

  }
}
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {
  public Node copyRandomList(Node head) {

    Node curr = head;
    while (curr!=null){
      Node node1 = new Node(curr.val);
      node1.next = curr.next;
      curr.next = node1;
      curr = curr.next.next;
    }

    curr = head;
    while (curr!=null){
      if(curr.random!=null){
        curr.next.random = curr.random.next;
      }
      curr = curr.next.next;
    }

    Node copyRoot = new Node(-1);
    Node copyCurrent = copyRoot;
    curr = head;
    while (curr!=null){

      Node temp = curr.next.next;
      copyCurrent.next = curr.next;
      copyCurrent = copyCurrent.next;
      curr.next = temp;
      curr = curr.next;
    }
    return copyRoot.next;
  }
}
