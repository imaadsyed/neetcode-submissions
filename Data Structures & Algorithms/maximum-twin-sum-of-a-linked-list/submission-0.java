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
    public int pairSum(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        Stack<ListNode> stack = new Stack<>();
        
        while(right.next != null) {
            stack.add(right);
            right = right.next;
        }

        int i = 0;
        int max = 0;
        while (!stack.isEmpty()) {
            int sum = left.val + right.val;

            if (sum > max) {
                max = sum; 
            }

            left = left.next;
            right = stack.pop();
        }

        return max;
    }
}