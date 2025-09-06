package heap.mergeKSortedLinkedList;

import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedListDriver {

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
  public ListNode mergeKLists(ListNode[] lists) {

    if(lists == null || lists.length == 0){
      return null;
    }

    Queue<ListNode> queue = new PriorityQueue<>((l1,l2)->Integer.compare(l1.val,l2.val));
    ListNode root = new ListNode();
    ListNode curr = root;

    for (int i = 0; i < lists.length; i++) {
      if(lists[i] != null){
        queue.offer(lists[i]);
      }
    }

    while (!queue.isEmpty()){

      ListNode node = queue.poll();
      curr.next = node;
      curr = curr.next;
      if(node.next != null){
        queue.offer(node.next);
      }

    }
    return root.next;


  }
}