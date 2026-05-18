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
    public ListNode rotateRight(ListNode head, int k) {
        // k - 1.next = null
        // k last element = head
        // tail.next = head
        // O(n)
        int length = getListLength(head);
        if (head == null) {
            return null;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        k = length - k;

        // O(n)
        ListNode newTail = getNodeAt(head, k - 1);
        // O(n)
        ListNode newHead = getNodeAt(head, k);
        // O(n)
        ListNode tail = getLastNode(head);

        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }

    private int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        return 1 + getListLength(head.next);
    }

    private ListNode getNodeAt(ListNode head, int k) {
        if (k == 0 || head.next == null) {
            return head;
        }

        return getNodeAt(head.next, k-1);
    }

    private ListNode getLastNode(ListNode head) {
        if (head.next == null) {
            return head;
        }

        return getLastNode(head.next);
    }
}

// time complexity: O(n)
// space complexity: O(n)