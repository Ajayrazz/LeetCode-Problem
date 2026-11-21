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
    public int numComponents(ListNode head, int[] nums) {
        if(head == null) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode current = head;
        int component = 0;
        while(current != null){
            int currentSize = set.size();
            while(current != null && set.contains(current.val)){
                set.remove(current.val);
                current = current.next;
            }
            //update component
            if(set.size() < currentSize){
                component += 1;
            }
            else {
                current = current.next;
            }
        }

        return component;
    }
}