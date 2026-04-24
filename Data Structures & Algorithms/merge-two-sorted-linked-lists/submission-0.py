# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = None
        cur = None
        while ((list1 is not None) or (list2 is not None)):
            # find min
            min = None
            if list1 is None:
                min = list2
                list2 = list2.next
            elif list2 is None:
                min = list1
                list1 = list1.next
            elif list1.val <= list2.val:
                min = list1
                list1 = list1.next
            else:
                min = list2
                list2 = list2.next

            print(min.val)
            # Add to list
            if head is None:
                head = min
                cur = head
            else:
                cur.next = min
                cur = cur.next
            
        return head
            