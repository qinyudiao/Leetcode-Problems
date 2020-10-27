package linked_list_cycle_141;

import utilities.ListNode;

//    Given head, the head of a linked list, determine if the linked list has a cycle in it.
//    
//    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
//    Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//    
//    Return true if there is a cycle in the linked list. Otherwise, return false.

//    Follow up:
//        Can you solve it using O(1) (i.e. constant) memory?

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head1 = new ListNode(new Integer[] {3, 2, 0, -4});
        ListNode curr1 = head1;
        ListNode next1 = null;
        while(curr1.next != null) {
            if(curr1.val == 2)
                next1 = curr1;
            curr1 = curr1.next;
        }
        curr1.next = next1;
        
        ListNode head2 = new ListNode(new Integer[] {1, 2});
        ListNode curr2 = head2;
        while(curr2.next != null) {
            curr2 = curr2.next;
        }
        curr2.next = head2;
        
        ListNode head3 = new ListNode(new Integer[] {1});
        
        System.out.println(solution.hasCycle(head1));
        System.out.println(solution.hasCycle(head2));
        System.out.println(solution.hasCycle(head3));
    }
    
    // Idea: use two pointers to track nodes in the list at a different speed, 
    // if there's a cycle, two pointers will eventually stop at the same node.
    // T(n) = O(n).
    // S(n) = O(1).
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);
        
        return true;
    }
}
