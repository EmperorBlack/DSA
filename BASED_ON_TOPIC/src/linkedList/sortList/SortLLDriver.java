package linkedList.sortList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLLDriver {

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
  public ListNode sortList(ListNode head) {

    ListNode current = head;
    List<Integer> list = new ArrayList<>();
    while (current!= null){
      list.add(current.val);
      current = current.next;
    }
    Collections.sort(list);

    current = head;
    int index = 0;
    while (current!= null){
      current.val = list.get(index);
      index++;
      current = current.next;
    }
    return head;
  }
}


class Solution_merge {
  public ListNode sortList(ListNode head) {

    if(head == null || head.next == null){
      return head;
    }

    ListNode pre = null;
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null){
      fast = fast.next.next;
      pre = slow;
      slow = slow.next;
    }

    pre.next = null;

    ListNode l1 = sortList(slow);
    ListNode l2 = sortList(head);

    return merge(l1,l2);


  }

  public ListNode merge(ListNode left,ListNode right) {

    ListNode temp = new ListNode(-1);
    ListNode current = temp;

    while (left != null && right!= null){
      if(left.val <= right.val){
        current.next = left;
        left = left.next;
      }else{
        current.next = right;
        right = right.next;
      }
      current = current.next;
    }

    if (left != null){
        current.next = left;
    }

    if (right != null){
      current.next = right;
    }
    return temp.next;
  }
}

