class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node() {}
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// Use hashmap (key, node) and linked list (node)
class LRUCache {    
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node left;
    Node right;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node();
        right = new Node();
        left.next = right;
        right.prev = left;
    }
    
    public void insert(Node node) {
        Node prev = right.prev;
        Node next = right;
        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
        map.put(node.key, node);
        if (map.size() > capacity) remove(left.next);
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        insert(node);
    }
}

