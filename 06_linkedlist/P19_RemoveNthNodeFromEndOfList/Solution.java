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

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dNode = new ListNode();
		ListNode slow = dNode;
		ListNode fast = dNode;
		dNode.next = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dNode.next;
	}

        public static void main(String[] args) {
                try (FileWriter fw = new FileWriter("output.txt");
                        BufferedWriter bw = new BufferedWriter(fw)) {

			int[][][] probs = {
				{{1,2,3,4,5}, {2}},
				{{1}, {1}},
				{{1,2}, {1}}
			};
			for (int[][] x: probs) {
				ListNode rNode = removeNthFromEnd(ListNode.generate(x[0]), x[1][0]);
				bw.write(Arrays.toString(ListNode.toArray(rNode)));
				bw.newLine();
			}
			

                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
}
