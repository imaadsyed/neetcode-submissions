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
    public ListNode mergeKLists(ListNode[] lists) {
        // System.out.println(lists[0].val);
        ListNode newHead = null;
        ListNode tail = null;
        /*
        while (each linkedlist cur is not null) {
            int min = min(ith linkedlist head)
            ith linkedlist head = ith linkedlist.next
        }
        */

        while (condition(lists)) {
            int min = 1001;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }
                }
            }

            ListNode node = new ListNode(lists[index].val);
            if (newHead == null || tail == null) {
                newHead = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            lists[index] = lists[index].next;
        }
        return newHead;
    }

    private boolean condition(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return true;
            }
        }
        return false;
    }
}
