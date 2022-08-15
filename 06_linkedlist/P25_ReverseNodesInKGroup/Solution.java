public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dNode = new ListNode();
        dNode.next = head;
        ListNode groupPrev = dNode;
        while (true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break; // span < k
            ListNode groupNext = kth.next;
            
            reverse(groupPrev.next, groupNext);
            
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dNode.next;
    }
    
    public ListNode getKthNode(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
    
    public ListNode reverse(ListNode head, ListNode prev) {
        ListNode tail = prev;
        while (head != prev) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}
