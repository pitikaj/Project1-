
public class Question3 {

	public static void main(String[] args) {
		int n = 15; 
		getRandomArray(n); 
		getSortedArray(n); 
		
	}
	
	public static int[] getSortedArray(int n) {
		int[] p = new int[n]; 
		int d = n; 
		for (int i = 0; i < n; i++){
			p[i] = d; 
			d--; 
		}
		for (int i = 0; i < p.length; i++) {
	        System.out.print(p[i]+" ");
	    	}
		return p; 
		
	}
	
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
}	

