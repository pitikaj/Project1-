
class Node {
	int node; 
	Node left, right;
	
	Node(int val) {
		node = val;
		left = null;
		right = null; 
	}
};

public class Question1 {

// How would you insert a new node into a BST? 
// Is the tree empty? Is the value greater than or less than the node? Is the value an int? 
// input = [2, 3, 4, 5,] insert 1; output = [1, 2, 3, 4, 5]
// if tree = empty -> insert to root; else, if less than root, add to left; else, if greater than root, add to right 
// O(size of array) is the time complexity if you have to add to the root because you have to go through the entire array 

	public static Node insertRec(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}

		if (val < root.node) {
			root.left = insertRec(root.left, val); //if val < root, add to left tree 
		}

		if (val > root.node) {
			root.right = insertRec(root.right, val); //if val < root, add to right tree 
		}

		return root;
	}
	
// How would you find the min value in a BST? 
// Is the tree empty? Is the value an int? 
// input = [2, 3, 4, 5,]; output = 2
// if root is the smallest element -> return root; else, run func on root.left until smallest value is found 
// O(logn) is the time complexity if you have only have to go through half the array 
	static int findMinRec(Node root) { 
    	if (root.left == null) 
        	return root.node; 
    	return findMinRec(root.left); 
		
	}
	
// How would you find the max value in a BST? 
// Is the tree empty? Is the value an int? 
// input = [2, 3, 4, 5,]; output = 5
// if root is the largest element -> return root; else, run func on root.right until largest value is found 
// O(logn) is the time complexity if you have only have to go through half the array 
	static int findMaxRec(Node root) { 
    	if (root.right == null) 
        	return root.node; 
    	return findMaxRec(root.right); 
		
	}
	
	static int findMinIter(Node root) { 
		while (root.left != null) { 
            root = root.left; 
        } 
        return (root.node); 
    }
    
    static int findMaxIter(Node root) { 
		while (root.right != null) { 
            root = root.right; 
        } 
        return (root.node); 
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
			root = insertRec(root, vals[i]);
		}
		
		insertRec(root, add); 
		int minRec = findMinRec(root); 
		int maxRec = findMaxRec(root);
		int minIter = findMinIter(root);
		int maxIter = findMaxIter(root);

		printTree(root);
		System.out.println("");
		System.out.println("findMinRec =" + " " + minRec);
		System.out.println("findMaxRec =" + " " + maxRec);
		System.out.println("findMinIter =" + " " + minIter);
		System.out.println("findMaxIter =" + " " + maxIter);
	}
}
