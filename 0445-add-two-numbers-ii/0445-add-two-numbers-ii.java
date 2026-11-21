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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = reverse(l1);
        ListNode temp2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;
        while(temp1 != null || temp2 != null || carry > 0){
            int sum = carry;
            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }
            //update temp
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }

        return reverse(dummy.next);
    }

    //reverse function
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode current = node;
        ListNode prev = null, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return node = prev;
    }
}