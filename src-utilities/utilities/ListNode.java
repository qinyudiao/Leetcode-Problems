package utilities;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode() {}
	public ListNode(int val) { this.val = val; }
	public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	public ListNode(Integer[] vals) {
	    if(vals == null || vals.length == 0)
	        return;
	    this.val = vals[0];
	    ListNode current = this;
	    for(int i = 1; i < vals.length; i++) {
	        if(vals[i] == null)
	            return;
	        ListNode next = new ListNode(vals[i]);
	        current.next = next;
	        current = next;
	    }
	}
	
	public String toStringInOrder() {
	    StringBuilder sb = new StringBuilder().append("{").append(this.val);
	    ListNode current = this;
	    while(current.next != null) {
	        current = current.next;
	        sb.append(", ").append(current.val);
	    }
	    
	    return sb.append("}").toString();
	}
}
