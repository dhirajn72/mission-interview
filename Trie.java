import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie(){
        this.root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode current = root;
        for (char l: word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
        }
        current.isEndOfWord=true;
    }
    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }
    public void delete(String word) {
        delete(root, word, 0);
    }
     
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord=false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord;
     
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }

    static class TrieNode{
        private HashMap<Character, TrieNode> children;
        private String content;
        private boolean isWord;
        private boolean isEndOfWord;

        public TrieNode(){
            this.children=new HashMap<>();
        }
    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        System.out.println("Insertion completes !!");
        
    }
}