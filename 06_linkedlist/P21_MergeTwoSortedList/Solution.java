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

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
	
        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String[] x = br.readLine().split("\\s*,\\s*");
				String[] y = br.readLine().split("\\s*,\\s*");
				int[] l1, l2;
				if (x[0].length() == 0) l1 = new int[0];
				else {
					l1 = new int[x.length];
					for (int i = 0; i < x.length; i++) {
						l1[i] = Integer.parseInt(x[i]);
					}
				}

				if (y[0].length() == 0) l2 = new int[0];
				else {
					l2 = new int[y.length];
					for (int i = 0; i < y.length; i++) {
						l2[i] = Integer.parseInt(y[i]);
					}
				}
				ListNode list1 = ListNode.generate(l1);
				ListNode list2 = ListNode.generate(l2);
				ListNode res = mergeTwoLists(list1, list2);
				bw.write(Arrays.toString(ListNode.toArray(res)));
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
