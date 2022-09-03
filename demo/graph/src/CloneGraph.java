import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	 static public Node cloneGraph(Node node) {
		if(node == null)
			return null;
		Node graph= new Node(node.val);
		Map<Node, Node> map = new HashMap<>();
		map.put(node, graph);
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		while(!q.isEmpty()){
			Node curr = q.poll();
			for(Node neighbor : curr.neighbors){
				if(!map.containsKey(neighbor)){
					map.put(neighbor, new Node(neighbor.val));
					q.offer(neighbor);
				}
				map.get(curr).neighbors.add(map.get(neighbor));
			}
		}
		return graph;
	}

	public static void main(String[] args) {
		int[][] nodes = {{2,4},{1,3},{2,4},{1,3}};
	}
	static class Node {
		public int val;
		public List<Node> neighbors;
		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}
		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<>();
		}
		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
