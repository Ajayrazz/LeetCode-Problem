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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;
        for(int i = 1; i < a; i++){
            temp1 = temp1.next;
        }

        ListNode temp2 = list1;
        for(int i = 0; i <= b; i++){
            temp2 = temp2.next;
        }

        ListNode temp3 = list2;
        while(temp3.next != null){
            temp3 = temp3.next;
        }

        temp3.next = temp2;
        temp1.next = list2;

        return list1;
    }
}