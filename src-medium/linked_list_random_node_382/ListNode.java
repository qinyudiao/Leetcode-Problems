package linked_list_random_node_382;

//	Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
//
//	Follow up:
//	What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}