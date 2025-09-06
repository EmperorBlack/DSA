package linkedList.DllReverse;



public class DLLReverseDriver {

  public static void main(String[] args) {


    DLLNode root = new DLLNode(2);
    DLLNode node1 = new DLLNode(4);
    DLLNode node2 = new DLLNode(5);

    root.next = node1;node1.prev = root;
    node1.next = node2; node2.prev = node1;

    new Solution().reverseDLL(root);
  }
}

class DLLNode {
  int data;
  DLLNode next;
  DLLNode prev;

  DLLNode(int val) {
    data = val;
    next = null;
    prev = null;
  }
}

class Solution {
  public DLLNode reverseDLL(DLLNode head) {
    // Your code here

    DLLNode current = head;
    DLLNode pre = null;

    while (current != null){

      DLLNode temp = current.next;

      current.next = pre;
      if(pre != null){
        pre.prev = current;
      }
      pre = current;
      current = temp;
    }
    pre.prev = null;
    return pre;

  }
}
