package linked_list_random_node_382;

import java.util.Random;

import utilities.ListNode;

//	Given a singly linked list, 
//	return a random node's value from the linked list. 
//	Each node must have the same probability of being chosen.

//	Follow up:
//	What if the linked list is extremely large and its length is unknown to you? 
//  Could you solve this efficiently without using extra space?

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
public class Solution {
	
	public static void main(String[] args) {
		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1, node2);
		ListNode head = new ListNode(0, node1);
		Solution solution = new Solution(head);
		
		double count = 0;
		for(int i = 0; i<10000; i++) {
			if(solution.getRandom() == 1)
				count++;
		}
		System.out.println(count/100 + "%");
	}

    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int size = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        Random rand = new Random(); 
        int random_num = rand.nextInt(size);
        temp = head;
        int count = 0;
        while(count<random_num){
            temp = temp.next;
            count++;
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

//	Runtime: 9 ms, faster than 98.37% of Java online submissions for Linked List Random Node.
//	Memory Usage: 40.3 MB, less than 97.83% of Java online submissions for Linked List Random Node.
