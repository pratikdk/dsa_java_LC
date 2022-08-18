class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class Trie {
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        
        for (Character c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        
        for (Character c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        
        for (Character c: prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
