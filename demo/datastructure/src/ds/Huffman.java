package ds;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Huffman {

	private Node root;
	private final String text;
	private Map<Character, Integer> charFrequencies;
	private final Map<Character, String> huffmanCodes;


	public Huffman(String text) {
		this.text = text;
		this.huffmanCodes = new HashMap<>();
		this.charFrequencies = new HashMap<>();
		for (char character : text.toCharArray()) {
			charFrequencies.put(character, charFrequencies.getOrDefault(character, 0 ) + 1 );
		}
	}

	public String encode() {
		java.util.PriorityQueue<Node> queue = new PriorityQueue<>();
		this.charFrequencies.forEach((character, frequency) -> queue.add(new Leaf(character, frequency)));
		while (queue.size() > 1) {
			queue.add(new Node(queue.poll(), Objects.requireNonNull(queue.poll())));
		}
		generateHuffmanCodes(root = queue.poll(), "");
		return getEncodedText();
	}

	private void generateHuffmanCodes(Node node, String code) {
		if (node instanceof Leaf) {
			this.huffmanCodes.put(((Leaf) node).character, code);
			return;
		}
		generateHuffmanCodes(node.leftNode, code.concat("0"));
		generateHuffmanCodes(node.rightNode, code.concat("1"));
	}

	private String getEncodedText() {
		StringBuilder sb = new StringBuilder();
		for (char character : text.toCharArray()) {
			sb.append(huffmanCodes.get(character));
		}
		return sb.toString();
	}

	public String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		Node current = root;
		for (char character : encodedText.toCharArray()) {
			current = character == '0' ? current.leftNode : current.rightNode;
			if (current instanceof Leaf) {
				sb.append(((Leaf) current).character);
				current = root;
			}
		}
		return sb.toString();
	}

	public void printCodes() {
		this.huffmanCodes.forEach((character, code) ->
				System.out.println(character + ": " + code)
		);
	}
	class Leaf extends Node {
		public final char character;
		public Leaf(char character, int frequency) {
			super(frequency);
			this.character = character;
		}
	}
	class Node implements Comparable<Node> {
		public final int frequency;
		public Node leftNode;
		public Node rightNode;

		public Node(Node leftNode, Node rightNode) {
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.frequency = leftNode.frequency + rightNode.frequency;
		}

		public Node(int frequency) {
			this.frequency = frequency;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(frequency, node.frequency);
		}

	}
	public static void main(String[] args) {

		//Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");
		Huffman huffman = new Huffman("aaabc");

		String encodedText = huffman.encode();
		System.out.println(encodedText);

		huffman.printCodes();

		String originalText = huffman.decode(encodedText);
		System.out.println(originalText);

		System.out.println(originalText.equals(huffman.text));
		System.out.println();
	}
}
