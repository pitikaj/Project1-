class Node { 
    int val; 
    int getHeight; 
    Node left, right; 
  
    Node(int d) { 
        val = d; 
        getHeight = 1; 
    } 
} 
  
class Question6a { 
  
    Node root; 
    static int counterAVL = 0; 
    static int counterBST = 0; 

    public static int[] getRandomArray(int n) {
    	int[] p = new int[n];

    	for (int i = 0; i < n; i++) {
    		p[i] = (int)(Math.random()*1000);

    		for (int j = 0; j < i; j++) {
    			if (p[i] == p[j]) {
    				i--; 
    				break;
    			}
    		}  
    	}

    for (int i = 0; i < p.length; i++) {
        System.out.print(p[i]+" ");
    	}
    System.out.println();
    return p;
    }

	public static Node insertIterBST(Node node, int val) {
		Node curr = node;
		Node parent = null;


		if (node == null) {
			return new Node(val);
		}

		while (curr != null) { //find parent of val being added 
			parent = curr;
			
			if (val < curr.val) { 
				curr = curr.left; //if val < root, go to left tree 
			}
			else {
				curr = curr.right;//if val > root, go to right tree 
			}
		}

		if (val < parent.val) {
			parent.left = new Node(val);//add to left tree
			counterBST += 1;
		}
		else {
			parent.right = new Node(val);//add to right tree 
			counterBST += 1;
		}
		//node = curr; 
		
		return node;
	}

    int getHeight(Node node) { 
        if (node == null) 
            return 0; 
  
        return node.getHeight; 
    } 
  
    int max(int a, int b) { 
    	if (a > b){
    		return a; 
    	}
    	
    	else 
    		return b;
    } 
  
    Node rightRotate(Node temp1) { 
        Node temp2 = temp1.left; 
        Node temp = temp2.right; 
  
        temp2.right = temp1; 
        temp1.left = temp; 
  
        temp1.getHeight = max(getHeight(temp1.left), getHeight(temp1.right)) + 1; 
        temp2.getHeight = max(getHeight(temp2.left), getHeight(temp2.right)) + 1; 
  
        return temp2; 
    } 
  
    Node leftRotate(Node temp2) { 
        Node temp1 = temp2.right; 
        Node temp = temp1.left; 
  
        temp1.left = temp2; 
        temp2.right = temp; 

        temp2.getHeight = max(getHeight(temp2.left), getHeight(temp2.right)) + 1; 
        temp1.getHeight = max(getHeight(temp1.left), getHeight(temp1.right)) + 1; 

        return temp1; 
    } 
  
    int bal(Node node) { 
        if (node == null) 
            return 0; 
  
        return getHeight(node.left) - getHeight(node.right); 
    } 
  
    Node insertIter(Node node, int val) { 
		//iterative insert 
		Node curr = node;
		Node parent = null;


		if (node == null) {
			return new Node(val);
		}

		while (curr != null) { //find parent of val being added 
			parent = curr;
			
			if (val < curr.val) { 
				curr = curr.left; //if val < root, go to left tree 
			}
			else {
				curr = curr.right;//if val > root, go to right tree 
			}
		}

		if (val < parent.val) {
			parent.left = new Node(val);//add to left tree
		}
		else {
			parent.right = new Node(val);//add to right tree 
		}

        node.getHeight = 1 + max(getHeight(node.left), 
                              getHeight(node.right)); 

        int balance = bal(node); 

        if (balance > 1) {
        	if (val < node.left.val){
            	return rightRotate(node); 
        	}
        }
  
        if (balance < -1) {
        	if(val > node.right.val) {
            	return leftRotate(node); 
        		}
        }
  
        if (balance > 1) {
        	if (val > node.left.val) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        	} 
        }
  
        if (balance < -1) {
        	if (val < node.right.val) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        	} 
        }
		counterAVL += 1;
        return node; 
    } 
  
	public static void printTree(Node node) {
		
		if (node == null) {
			return;
		}
		
		printTree(node.left);
		System.out.print(node.val + " "); 
		printTree(node.right);
    }
  
    public static void main(String[] args) { 
        Question6a newTree = new Question6a(); 

        Node newRoot = null; 

        int[] vals = {5, 57, 43, 10, 89, 66, 19};
		
		for (int i = 0; i < vals.length; i++ ){
            newTree.root = newTree.insertIter(newTree.root, vals[i]); 
		}
        
        for (int i = 0; i < vals.length; i++) {
		 	newRoot = insertIterBST(newRoot, vals[i]);
		 }
	
		
		System.out.println(""); 
        printTree(newTree.root); 
        System.out.println("AVL Counter = " + counterAVL); 
        System.out.println(""); 
        printTree(newRoot); 
        System.out.println("BST Counter = " + counterBST); 



    } 
} 
 
 