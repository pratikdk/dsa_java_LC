class ListNode {
    int val;
    int min;
    ListNode next;
    ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

class MinStack { // can also be implemented using a stack
    private ListNode head;
    
    public MinStack() {
        // head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new ListNode(val, val, head);
        } else {
            head = new ListNode(val, Math.min(head.min, val), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

