package rotate_list_61;

import utilities.ListNode;

//    Given a linked list, rotate the list to the right by k places, where k is non-negative.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Integer[][] testCasesLists = {{1, 2, 3, 4, 5, null}, {0, 1, 2, null}, {1}, {1, 2, 3}}; // {4, 5, 1, 2, 3}, {2, 0, 1}, {1}
        int[] testCasesK = {2, 4, 6, 1, 1};
        for(int i = 0; i < testCasesLists.length; i++) {
            ListNode node = new ListNode(testCasesLists[i]);
            System.out.println("Before: " + node.toStringInOrder());
            System.out.println("After: " + solution.rotateRight(node, testCasesK[i]).toStringInOrder());
        }
    }
    
    // Idea: Find the new Tail and break its link to the next node, then link the
    // original Tail to the original Head.
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        
        int size = 1;
        ListNode newTail = head;
        while(newTail.next != null) {
            size++;
            newTail = newTail.next;
        }
        int i = size - (k % size);
        for(; i > 0; i--) {
            if(newTail.next != null)
                newTail = newTail.next;
            else
                newTail = head;
        }
        
        if(newTail.next == null) // If the newTail is the same as the old Tail, return the head.
            return head;
        
        ListNode newHead = newTail.next;
        ListNode curr = newHead;
        newTail.next = null;
        if(curr != null) {
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = head;
        }
        
        return newHead;
    }
}
