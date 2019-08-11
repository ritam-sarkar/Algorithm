package test.oracle;

public class TripleCombination {

	public static void main(String[] args) {

		int[] a = {1,3,5};
		int[] b = {2,3};
		int[] c = {1,2,3};
		long count = triplets(a, b, c);
		System.out.println(count);
	}
	
	static long triplets(int[] a, int[] b, int[] c) {

	       int q=0;
	       int x = a.length;
	       int y = b.length;
	       int z = c.length;
	       
	       long count =0;
	       while(q<y){
	    	   if(q>0 && b[q] == b[q-1] || (a[0]>b[q]) || (c[0]>b[q])) {
	    		   q++;
	    		   continue;
	    	   }
	           long counta =0;
	           long countc =0;
	           int p =0;
	           int r=0;
	           
	           while(p<x){
	        	   if(p>0 && a[p] == a[p-1]) {
	        		   p++;
	        		   continue;
	        	   }
	        	   if(a[p]<= b[q])
	                 counta++;
	               p++;
	           }
	           while(r<z){
	        	   if(r>0 && c[r] == c[r-1]) {
	        		   r++;
	        		   continue;
	        	   }
	        	   if(b[q]>= c[r])
	                 countc++;
	               r++;
	           }
	           count = count+ (counta*countc);      
	           q++;     
	       }
	       return count;

 }

}
