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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        int size = 0;
        ListNode current = head;
        while(current != null){
            size += 1;
            current = current.next;
        }

        if(size < k) return head;
        current = head;
        ListNode next = null, prev = null;
        int count = 0;
        while(current != null && count < k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count += 1;
        }

        if(next != null){
            head.next = reverseKGroup(next, k);
        }

        return head = prev;
    }
}