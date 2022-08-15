import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>(); // (n+1)/2
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i+1 < lists.length) ? lists[i+1] : null;
                ListNode head = merge(l1, l2);
                mergedLists.add(head);
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dNode = new ListNode();
        ListNode tail = dNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dNode.next;
    }
}
