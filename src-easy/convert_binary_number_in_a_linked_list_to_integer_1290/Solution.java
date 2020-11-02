package convert_binary_number_in_a_linked_list_to_integer_1290;

import utilities.ListNode;

//    Given head which is a reference node to a singly-linked list. 
//    The value of each node in the linked list is either 0 or 1. 
//    The linked list holds the binary representation of a number.
//    
//    Return the decimal value of the number in the linked list.

//    Constraints:
//        The Linked List is not empty.
//        Number of nodes will not exceed 30.
//        Each node's value is either 0 or 1.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Integer[][] testCases = {{1, 0, 1}, {0}, {1}, {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0}}; // 5, 0, 1, 18880, 0
        for(Integer[] testCase : testCases) {
            System.out.println(solution.getDecimalValue(new ListNode(testCase)));
        }
    }
    
    public int getDecimalValue(ListNode head) {
        int result = head.val;
        
        while(head.next != null) {
            head = head.next;
            result = (result << 1) + head.val;
        }
        
        return result;
    }
}
