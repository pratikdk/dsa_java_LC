import java.io.*;
import java.util.*;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class Solution {

	public Node copyRandomList(Node head) {
	       Map<Node, Node> orgToCopy = new HashMap<>();
		orgToCopy.put(null, null);

		Node curr = head;
		while (curr != null) {
		    Node copy = new Node(curr.val);
		    orgToCopy.put(curr, copy);
		    curr = curr.next;
		}

		curr = head;
		while (curr != null) {
		    Node copy = orgToCopy.get(curr);
		    copy.next = orgToCopy.get(curr.next);
		    copy.random = orgToCopy.get(curr.random);
		    curr = curr.next;
		}

		return orgToCopy.get(head);
    	}
}
