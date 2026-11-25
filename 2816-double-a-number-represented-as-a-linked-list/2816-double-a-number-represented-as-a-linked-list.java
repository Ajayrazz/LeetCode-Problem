
class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = solve(head);
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private int solve(ListNode node) {
        if (node == null) {
            return 0;
        }
        int carry = solve(node.next);
        int sum = node.val * 2 + carry;
        node.val = sum % 10;
        return sum / 10;
    }
}
