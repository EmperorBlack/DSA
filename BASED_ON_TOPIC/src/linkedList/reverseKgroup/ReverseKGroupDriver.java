package linkedList.reverseKgroup;

public class ReverseKGroupDriver {

  public static void main(String[] args) {

    ListNode root = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
//    System.out.println(new Solution().reverseKGroup(root,3));

//    ListNode root = new ListNode(1);
    new Solution_2().rotateRight(root,10);
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
  public ListNode reverseKGroup(ListNode head, int k) {

    if(head == null){
      return null;
    }
    int i = 1;
    ListNode root = head;
    ListNode next = null;
    ListNode pre = null;
    while (head!=null){
      pre = head;
      head=head.next;
      i++;
      if(i > k){
       next = reverseKGroup(head,k);
       head = null;
       pre.next = null;
      }
    }
    if(i <= k ){
      return root;
    }
//    reverse th list;

    ListNode curr = root;
    ListNode prv = null;

    while (curr!=null){

      ListNode temp = curr.next;
      curr.next = prv;
      prv = curr;
      curr = temp;
    }

    root.next = next;
    return prv;

  }
}


class Solution_2 {
  public ListNode rotateRight(ListNode head, int k) {


    if(head == null){
      return null;
    }
    if(k <= 0){
      return head;
    }
    int length = 0;
    ListNode temp = head;

    while(temp!=null){
      temp = temp.next;
      length++;
    }
    if(length ==1 || length == k){
      return head;
    }
    k = k%length;

    if(k <= 0){
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;
    for(int i =0; i< k;i++){
      fast = fast.next;
    }

    while(fast.next != null){
      fast = fast.next;
      slow = slow.next;
    }

    ListNode root = slow.next;
    slow.next = null;
    fast.next = head;
    return root;

  }
}