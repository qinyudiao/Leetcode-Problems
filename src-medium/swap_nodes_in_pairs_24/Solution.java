package swap_nodes_in_pairs_24;

import utilities.ListNode;

//	Given a linked list, swap every two adjacent nodes and return its head.
//	You may not modify the values in the list's nodes, only nodes itself may be changed.
//	
//	Example:
//		Given 1->2->3->4, you should return the list as 2->1->4->3.
		
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
		    return head;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p = h;

		while(p.next != null && p.next.next != null) {

		    ListNode t1 = p;
		    p = p.next;
		    t1.next = p.next;

		    ListNode t2 = p.next.next;
		    p.next.next = p;
		    p.next = t2;
		}

		return h.next;
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
//	Memory Usage: 39 MB, less than 22.76% of Java online submissions for Swap Nodes in Pairs.
