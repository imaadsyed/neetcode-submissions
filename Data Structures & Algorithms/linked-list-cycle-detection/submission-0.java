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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> uniqueNodes = new HashSet<>();

        ListNode node = head;
        while(node != null) {
            if (uniqueNodes.contains(node)) {
                return true;
            }
            uniqueNodes.add(node);
            node = node.next;
        }
        return false;
    }
}
