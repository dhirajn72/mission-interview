package ds;

public class Trie {
	Node root ;
	Trie(){
		root = new Node('\0');
	}

	boolean isWordAvailable(String word){
		Node node = getNode(word);
		return node != null && node.isWord;
	}
	boolean startsWith(String word){
		Node node = getNode(word);
		return node != null;
	}
	void insert(String word){
		Node curr = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null){
				curr.children[c - 'a'] = new Node(c);
			}
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
	}
	Node getNode(String word){
		Node curr = root;
		for(int i = 0 ; i < word.length(); i++){
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null)
				return null;
			curr = curr.children[c - 'a'];
		}
		return curr;
	}

	class Node{
		char c;
		boolean isWord;
		Node[] children;
		Node(char c){
			this.c = c;
			this.children = new Node[26];
		}
	}
	public static void main(String[] args){
		String[] words = {"apple","basket","ball","apply","intelligent","indulgence",};
		Trie trie = new Trie();
		for(String word : words){
			trie.insert(word);
		}
		System.out.println(trie.isWordAvailable("apple"));
		System.out.println(trie.isWordAvailable("ball"));
		System.out.println(trie.isWordAvailable("cat"));
		System.out.println(trie.startsWith("intel"));
	}
}
