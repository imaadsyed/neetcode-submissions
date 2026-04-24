# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Maintain a recursive stack of nodes as we traverse them in the forward directions
# When we hit null (tail node), pop from stack node.next = stack.pop()
# When stack is empty, set node.next (prev head node) = null.

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # print(head.val, head.next.val)
        node = head
        if node is None:
            return None
    
        newHead = head
    
        print("node.val", node.val)
        print("newHead", newHead.val)
        
        # recurse until you hit last 2 nodes
        if node.next:
            newHead = self.reverseList(node.next)
            node.next.next = node
        node.next = None
    
        return newHead


'''
# -> 1 -> 2 -> #
'''