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
    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        return removeNthFromEnd(head);   
    }

    private ListNode removeNthFromEnd(ListNode node) {
        if (node == null) {
            return null;
        }

        node.next = removeNthFromEnd(node.next);
        this.n--;

        if (n == 0) {
            return node.next;
        }

        return node;
    }
}
