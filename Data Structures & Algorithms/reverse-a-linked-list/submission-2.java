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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node.next != null) {
            stack.add(node);
            node = node.next;
        }
        ListNode newHead = node;

        while (!stack.isEmpty()) {
            ListNode prevNode = stack.pop();
            node.next = prevNode;
            node = prevNode;
            if (node == head) {
                node.next = null;
            }
        }

        return newHead;
    }
}
