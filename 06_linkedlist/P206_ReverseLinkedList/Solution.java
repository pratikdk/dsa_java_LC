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

	public static ListNode reverseList(ListNode node) {
		ListNode head = null;
		while (node != null) {
			ListNode next = node.next;
			node.next = head;
			head = node;
			node = next;
		}
		return head;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String[] x = br.readLine().split("\\s*,\\s*");
				int[] nums;
				if (x[0].length() == 0) nums = new int[0]; 
				else {
					nums = new int[x.length]; 
					for (int i = 0; i < x.length; i++) {
						nums[i] = Integer.parseInt(x[i]);
					}
				}
				ListNode head = ListNode.generate(nums);
				ListNode rHead = reverseList(head);
				bw.write(Arrays.toString(ListNode.toArray(rHead)));
				bw.newLine();		
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
