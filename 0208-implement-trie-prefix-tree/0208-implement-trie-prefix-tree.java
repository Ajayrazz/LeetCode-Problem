class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node current = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */