import java.io.*;
import java.util.*;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}

        public static ListNode generate(int[] nums) {
                ListNode dNode = new ListNode();
                ListNode head = dNode;
                for (int num: nums) {
                        head.next = new ListNode(num);
                        head = head.next;
                }
                return dNode.next;
        }

        public static Integer[] toArray(ListNode node) {
                List<Integer> res = new ArrayList<>();
                while (node != null) {
                        res.add(node.val);
                        node = node.next;
                }
                return res.toArray(new Integer[0]);
        }
}

public class Solution {

	public static void reorderList(ListNode head) {
		// find middle node
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = slow.next; // second half node
		slow.next = null; // first half end

		// reverse edges between the nodes of second half
		ListNode prev = null;
		while (second != null) {
			ListNode next = second.next;
			second.next = prev;
			prev = second;
			second = next;
		}
		
		// merge using head and second
		ListNode first = head;
		second = prev;
		while (first != null && second != null) {
			ListNode next1 = first.next;
			ListNode next2 = second.next;
			
			first.next = second;
			second.next = next1;
			
			first = next1;
			second = next2;
		}	
	}

        public static void main(String[] args) {
                try (FileWriter fw = new FileWriter("output.txt");
                        BufferedWriter bw = new BufferedWriter(fw)) {

			int[][] ll = {
				{1,2,3,4},
				{1,2,3,4,5}
			};
			
			for (int[] l: ll) {
				ListNode head = ListNode.generate(l);
				reorderList(head);
				bw.write(Arrays.toString(ListNode.toArray(head)));
				bw.newLine();
			}	

                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
}
