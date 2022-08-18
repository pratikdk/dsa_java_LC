class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean endOfWord = false;
}
class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        // dfs on '.' character, while iterate on any other lowercase alphabet
        return dfsTrie(0, this.root, word);
    }
    
    private boolean dfsTrie(int start, TrieNode node, String word) {
        TrieNode curr = node;
        
        for (int i = start; i < word.length(); i++) {
            Character c = word.charAt(i);
            
            if (c == '.') {
                for (TrieNode iChildNode: curr.children.values()) {
                    if (dfsTrie(i+1, iChildNode, word)) {
                        return true;
                    }
                }
                return false;
            } else { // any lowercase alphabet
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
        }
        
        return curr.endOfWord;
    }  
}
