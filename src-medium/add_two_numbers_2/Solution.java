package add_two_numbers_2;

import java.util.ArrayList;
import java.util.List;

import utilities.ListNode;

//	You are given two non-empty linked lists representing two non-negative integers. 
//	The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//	
//	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

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
		Solution solution = new Solution();
		
		// Testcase a
		int[] a1 = {2, 4, 3};
		int[] a2 = {5, 6, 4};
		printList(solution.addTwoNumbers(getListNodeFromArray(a1), getListNodeFromArray(a2))); // [7, 0, 8], 342 + 465 = 807
	
		
		// Testcase b
		int[] b1 = {9};
		int[] b2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
		printList(solution.addTwoNumbers(getListNodeFromArray(b1), getListNodeFromArray(b2))); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1], 999999999991 + 9 = 1000000000000
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), cur = head;
		int num1 = 0, num2 = 0;
		int carry = 0;
		while(l1 != null || l2 != null) {
			num1 = (l1 != null) ? l1.val : 0;
			num2 = (l2 != null) ? l2.val : 0;
			int sum = num1 + num2 + carry;
			carry = sum / 10;
			
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			
	        if (l1 != null) l1 = l1.next;
	        if (l2 != null) l2 = l2.next;
		}
		if (carry > 0) {
	        cur.next = new ListNode(carry);
	    }
		return head.next;
	}
	
	// only works with sum < Integer.MAX_VALUE.
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		int sum = l1.val + l2.val;
		int power = 0;
		while(l1.next != null) {
			l1 = l1.next;
			power++;
			sum += l1.val * Math.pow(10, power);
		}
		
		power = 0;
		while(l2.next != null) {
			l2 = l2.next;
			power++;
			sum += l2.val * Math.pow(10, power);
		}
		
		if(sum == 0)
			return new ListNode(0);
		
		List<ListNode> digits = new ArrayList<>();
		while(sum != 0) {
			digits.add(new ListNode(sum % 10));
			sum /= 10;
		}
		
		for(int i = 0; i < digits.size() - 1; i++) {
			digits.get(i).next = digits.get(i + 1);
		}
		
		return digits.get(0);
	}
	
	// print the acyclic listNode through
	private static void printList(ListNode l) {
		System.out.print(l.val);
		while(l.next != null) {
			l = l.next;
			System.out.print(", " +l.val);
		}
		System.out.println();
	}
	
	private static ListNode getListNodeFromArray(int[] array) {
		ListNode head = new ListNode(0), cur = head;
		
		for(int i = 0; i < array.length; i++) {
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
		
		return head.next;	
	}
}
