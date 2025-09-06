package linkedList.Palliandrome;

public class PalliandromeDriver {

  public static void main(String[] args) {

  }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


class Solution {
  public boolean isPalindrome(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast!=null && fast.next!=null){

      fast = fast.next.next;
      slow = slow.next;

    }

    ListNode pre = slow;
    ListNode current = pre.next;

    while (current!= null){
      ListNode temp = current.next;
      current.next = pre;
      pre = current;
      current = temp;
    }

    while (pre != null && head!=null){

      if(pre.val != head.val){
        return false;
      }
      pre = pre.next;
      head = head.next;
    }

    return true;




  }
}