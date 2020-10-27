package linked_list_cycle_II_142;

import utilities.ListNode;

//    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//    
//    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//    
//    Notice that you should not modify the linked list.

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
        
        System.out.println(solution.detectCycle(head1));
        System.out.println(solution.detectCycle(head2));
        System.out.println(solution.detectCycle(head3));
    }
    
    // Idea: use two pointers to track nodes in the list at a different speed,
    // if there's a cycle, two pointers will eventually stop at the same node.
    // After that, make a new node travel from the head and it will meet with
    // slow node at the start of the cycle.
    // T(n) = O(n).
    // S(n) = O(1).
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);
        
        ListNode slow2 = head;
        while(slow2 != slow) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        
        return slow;
    }
}
