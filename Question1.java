
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
			root.right = insertRec(root.right, val); //if val > root, add to right tree 
		}

		return root;
	}

// How would you find the next node given a value in a BST? 
// Is the tree empty? Is the value an int? Does the next node exist? 
// input = [2, 3, 4, 5,] int = 3; output = 4
// if root = value -> return smallest value; else, run func on root.left if value < root value; else, run func on root.right if value > root value
// O(logn) is the time complexity if you have only have to go through half the array 
	static int findNextRec(Node root, Node next, int val) {

		if (root.node == val) {
			if (root.right != null) {
				return findMinRec(root.right);
			}
		}

		else if (val < root.node) { //if val < root, search to left tree 
			next = root;
			return findNextRec(root.left, next, val);
		}

		else if (val > root.node) { //if val > root, search to left tree 
			return findNextRec(root.right, next, val);
		}

		return next.node;
	}
	
// How would you find the prev node given a value in a BST? 
// Is the tree empty? Is the value an int? Does the prev node exist? 
// input = [2, 3, 4, 5,] int = 3; output = 2
// if root = value -> return max value; else, run func on root.left if value < root value; else, run func on root.right if value > root value
// O(logn) is the time complexity if you have only have to go through half the array 
	static int findPrevRec(Node root, Node prev, int val)
	{

		if (root.node == val) {
			if (root.left != null) {
				return findMaxRec(root.left);
			}
		}

		else if (val < root.node) { //if val < root, search to left tree
			prev = root;
			return findPrevRec(root.left, prev, val);
		}

		else if (val > root.node) { //if val > root, search to right tree
			prev = root;
			return findPrevRec(root.right, prev, val);
		}
		return (prev.node);
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

	public static Node insertIter(Node root, int val) {
		Node curr = root;
		Node parent = null;


		if (root == null) {
			return new Node(val);
		}

		while (curr != null) { //find parent of val being added 
			parent = curr;
			
			if (val < curr.node) { 
				curr = curr.left; //if val < root, go to left tree 
			}
			else {
				curr = curr.right;//if val > root, go to right tree 
			}
		}

		if (val < parent.node) {
			parent.left = new Node(val);//add to left tree
		}
		else {
			parent.right = new Node(val);//add to right tree 
		}

		return root;
	}

	static int findPrevIter(Node root, Node prev, int val)	{
    	while (root != null) {
        	if (val > root.node) {
            	prev = root;
            	root = root.right;
        	}
        	else if (val < root.node){
            	root = root.left;
        	}
        else
           break;
    	}
    	return (prev.node);

		
	}
		
	static int findNextIter(Node root, Node next, int val)	{
    	while (root != null) {
        	if (val < root.node) {
            	next = root;
            	root = root.left;
        	}
        	else if (val > root.node){
        		//root = root; 
        		//next = root;
            	root = root.right;
        	}
        else
           break;
    	}
    	return (next.node);
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


	public static void main(String[] args) {
		Node root = null;
		int[] vals = {5, 57, 43, 10, 89, 66, 19};
		int add = 7;
		int addIter = 25; 

		for (int i = 0; i < vals.length; i++) {
			root = insertRec(root, vals[i]);
		}
		
		insertRec(root, add); 
		insertIter(root, addIter);
		
		int next = 25; 
		int prev = 19; 
		
		int nextRec = findNextRec(root, null, next);
		int nextIter = findNextIter(root, null, next);
		
		int prevRec = findPrevRec(root, null, prev);
		int prevIter = findPrevIter(root, null, prev); 
		
		
		int minRec = findMinRec(root); 
		int minIter = findMinIter(root);
		
		int maxRec = findMaxRec(root); 
		int maxIter = findMaxIter(root);
		

		printTree(root);
		System.out.println("");
		System.out.println("Node after " + next + " = " + nextRec); 
		System.out.println("Node before " + prev + " = " + prevRec); 
		System.out.println("findMinRec =" + " " + minRec);
		System.out.println("findMaxRec =" + " " + maxRec);
		System.out.println("Node after " + next + " = " + nextIter); 
		System.out.println("Node before " + prev + " = " + prevIter); 
		System.out.println("findMinIter =" + " " + minIter);
		System.out.println("findMaxIter =" + " " + maxIter);
	}
}
