/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode oHead = head;
         ListNode slow = head;
        ListNode fast = head; // 1 2 3 4 5
        // 1 2 3 4 5 6 7
        ListNode prev  = null;
        if(head.next == null)
            return null;
       while(fast != null && fast.next != null){
           prev = slow;
           slow = slow.next;
           fast = fast.next.next;
       }
        prev.next = slow.next;
        return oHead;
    }
}