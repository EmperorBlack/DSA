package linkedList.AddTwoNumber;

public class AddTwoNumberDriver {

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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(-1);
    ListNode curr = result;
    int carry = 0;
    while(l1 != null || l2!= null){

      int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
      curr.next = new ListNode(sum%10);
      carry = sum/10;
      curr = curr.next;
      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }
    if(carry > 0){
      curr.next = new ListNode(carry);
    }
    return result.next;

  }
}


