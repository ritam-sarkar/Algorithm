package array;

public class FibonacciSeries {

	public static void main(String[] args) {

		fibo(7);
	}
	public static void fibo(int n) {
		
		int a =0;
		int b =1;
		int c =0;
		int sum=a+b;
		if(n ==0) {
			System.out.println(0);
			System.out.println("summation is"+0);
		}else if(n ==1) {
			System.out.println(1);
			System.out.println("summation is"+1);
		}else {			
			for(int i =1 ; i<n ; i++) {
			    c = a+b;
			    a = b;
			    b = c;
			    sum += c;
			}
			
			System.out.println("nth element is "+c);
			System.out.println("Summation is "+sum);
		}		
	}

}
