class Trie {
    Node  root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new Node('\0');
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)
                curr.children[c-'a']=new Node(c);
            curr=curr.children[c-'a'];
        }
        curr.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node=getNode(word);
        return node!=null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return  getNode(prefix)!=null;
    }
        
    Node getNode(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)
                return null;
            curr=curr.children[c-'a'];
        }
        return curr;
    }


    class Node{
        char data;
        boolean isWord;
        Node[] children;
        Node(char c){
            this.data=c;
            children=new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
