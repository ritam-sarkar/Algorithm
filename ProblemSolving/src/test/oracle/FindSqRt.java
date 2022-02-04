package test.oracle;

public class FindSqRt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(sqrt(2147395599));
		
	}
	public static int sqrt(int x) {
		// Base cases 
	    if (x == 0 || x == 1)  
	       return x; 
	  
	    // Do Binary Search for floor(sqrt(x)) 
	    long start = 1, end = x/2, ans =start;
	    
	    while (start <= end)  
	    {         
	        long mid = (start + end) / 2; 
	  
	        if (mid*mid == x) 
	            return (int)mid; 
	  
	        if (mid*mid < x)  
	        { 
	            start = mid + 1; 
	            ans = mid; 
	        }  
	        else 
	            end = mid-1;         
	    } 
	    return (int)ans; 
	}

}
