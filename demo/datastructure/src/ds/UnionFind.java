package ds;

/**
 * ds.UnionFind/Disjoint Set data structure implementation. This code was inspired by the union find
 * implementation found in 'Algorithms Fourth Edition' by Robert Sedgewick and Kevin Wayne.
 *
 */
public class UnionFind {
	private int max;
	private int[] size;
	private int[] id;
	private int numComponents;

	public UnionFind(int max) {
		this.max = numComponents = max;
		size = new int[max];
		id = new int[max];
		for (int i = 0; i < max; i++) {
			id[i] = i; // Link to itself (self root)
			size[i] = 1; // Each component is originally of max one
		}
	}

	// Find which component/set 'p' belongs to, takes amortized constant time.
	public int find(int p) {

		// Find the root of the component/set
		int root = p;
		while (root != id[root])
			root = id[root];

		// Compress the path leading back to the root.
		// Doing this operation is called "path compression"
		// and is what gives us amortized time complexity.
		while (p != root) {
			int next = id[p];
			id[p] = root;
			p = next;
		}

		return root;
	}

	// This is an alternative recursive formulation for the find method
	// public int find(int p) {
	//   if (p == id[p]) return p;
	//   return id[p] = find(id[p]);
	// }



	// Return whether or not the elements 'p' and
	// 'q' are in the same components/set.
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	// Return the size of the components/set 'p' belongs to
	public int componentSize(int p) {
		return size[find(p)];
	}

	// Return the number of elements in this ds.UnionFind/Disjoint set
	public int size() {
		return max;
	}

	// Returns the number of remaining components/sets
	public int components() {
		return numComponents;
	}

	// Unify the components/sets containing elements 'p' and 'q'
	public void unify(int p, int q) {

		int root1 = find(p);
		int root2 = find(q);

		// These elements are already in the same group!
		if (root1 == root2) return;


		// Merge smaller component/set into the larger one.
		if (size[root1] < size[root2]) {
			size[root2] += size[root1];
			id[root1] = root2;
			size[root1] = 0;
		} else {
			size[root1] += size[root2];
			id[root2] = root1;
			size[root2] = 0;
		}

		// Since the roots found are different we know that the
		// number of components/sets has decreased by one
		numComponents--;
	}
	public static void main(String[] args){
		UnionFind unionFind = new UnionFind(8);
		unionFind.unify(3,4); // Merge 3 and 4 into a single set
		unionFind.unify(4,1); // Merge 3 and 4 into a single set
		unionFind.unify(5,2); // Merge 3 and 4 into a single set
		unionFind.unify(6,3); // Merge 3 and 4 into a single set
		unionFind.unify(7,3); // Merge 3 and 4 into a single set
		System.out.println(unionFind.find(6));

	}
}
