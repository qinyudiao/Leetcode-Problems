package sort_list_148;

import utilities.ListNode;

//    Given the head of a linked list, return the list after sorting it in ascending order.
//    
//    Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

//    Constraints:
//        The number of nodes in the list is in the range [0, 5 * 104].
//        -105 <= Node.val <= 105

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Integer[][] testCases = {{4, 2, 1, 3}, {-1, 5, 3, 4, 0}, {}}; // "abc", "acdb"
        for(Integer[] testCase : testCases) {
            ListNode head = testCase.length != 0 ? new ListNode(testCase) : null;
            System.out.println(solution.sortList(head));
        }
    }

    // Merge sort
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);

        return merge(n1, n2);
    }

    ListNode merge(ListNode n1, ListNode n2) {
        ListNode n = new ListNode(0), p = n;

        while(n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                p.next = n1;
                n1 = n1.next;
            }
            else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }

        if(n1 != null)
            p.next = n1;
        if(n2 != null)
            p.next = n2;

        return n.next;
    }
}
