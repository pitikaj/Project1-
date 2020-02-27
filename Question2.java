
class Node {
	int node; 
	Node left, right;
	
	Node(int val) {
		node = val;
		left = null;
		right = null; 
	}
};

public class Question2 {

	public static Node insert(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}

		if (val < root.node) {
			root.left = insert(root.left, val); //if val < root, add to left tree 
		}

		if (val > root.node) {
			root.right = insert(root.right, val); //if val < root, add to right tree 
		}

		return root;
	}
	
		public static void printTree(Node root) {
		
		if (root == null) {
			return;
		}
		
		printTree(root.left);
		System.out.print(root.node + " "); 
		printTree(root.right);
	}


	public static void main(String[] args)
	{
		Node root = null;
		int[] vals = {5, 57, 43, 10, 89, 66, 19};
		int add = 7;

		for (int i = 0; i < vals.length; i++) {
			root = insert(root, vals[i]);
		}
		
		insert(root, add); 

		printTree(root);
	}
}