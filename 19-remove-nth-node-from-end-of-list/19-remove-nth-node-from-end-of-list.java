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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode prev = node;
        ListNode forw = node;
        int i = 0;
        while(i < n){
            prev = prev.next; i++;
        }
        while(prev.next != null){
            forw = forw.next; prev = prev.next;
        }
        forw.next = forw.next.next;
        return node.next;
    }
    
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5
    // 0 -> 1
    
}