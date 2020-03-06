class Node { 
    int val; 
    int getHeight; 
    Node left, right; 
  
    Node(int d) { 
        val = d; 
        getHeight = 1; 
    } 
} 
  
class Question4 { 
  
    Node root; 

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
  
        return node; 
    } 
    
    static int findPrevIter(Node node, Node prev, int val)	{
    	while (node != null) {
        	if (val > node.val) {
            	prev = node;
            	node = node.right;
        	}
        	else if (val < node.val){
            	node = node.left;
        	}
        else
           break;
    	}
    	return (prev.val);

		
	}
		
	static int findNextIter(Node node, Node next, int val)	{
    	while (node != null) {
        	if (val < node.val) {
            	next = node;
            	node = node.left;
        	}
        	else if (val > node.val){
        		
        		next = node;
            	node = node.right.right;
        	}
        else
           break;
    	}
    	return (next.val);
	}	
    
    static int findMinIter(Node node) { 
		while (node.left != null) { 
            node = node.left; 
        } 
        return (node.val); 
    }
    
   static int findMaxIter(Node node) { 
		while (node.right != null) { 
            node = node.right; 
        } 
        return (node.val); 
    }
  
    void preOrder(Node node) { 
        if (node != null) { 
            preOrder(node.left); 
    		System.out.print(node.val + " ");
            preOrder(node.right); 
        } 
    } 
  
    public static void main(String[] args) { 
        Question4 newTree = new Question4(); 
       
		int[] vals = {5, 57, 43, 10, 89, 66, 19};
		
		for (int i = 0; i < vals.length; i++ ){
			newTree.root = newTree.insertIter(newTree.root, vals[i]);
		}
		
		newTree.root = newTree.insertIter(newTree.root, 8);
 
        newTree.preOrder(newTree.root); 
        System.out.println(""); 
       
        
        int next = 57;
		int prev = 8; 
		
		int nextIter = findNextIter(newTree.root, null, next);
		int prevIter = findPrevIter(newTree.root, null, prev); 
        
        int minIter = findMinIter(newTree.root);
		int maxIter = findMaxIter(newTree.root);
		
		System.out.println("findNextIter =" + " " + nextIter);
		System.out.println("findPrevIter =" + " " + prevIter);
		System.out.println("findMinIter =" + " " + minIter);
		System.out.println("findMaxIter =" + " " + maxIter);
    } 
} 
 