package array;

public class Fibonaci {

	public static void main(String[] args) {
         System.out.println(fibo(5));
	}
	
	private static int fibo(int n) {
		int a=0,b=1,c=0;
		int sum =a+b;
		if(n <=1) {
			System.out.println("summation is "+n);
			return n;
		}
		for(int i=2;i<=n;i++) {
			c = a+b;
			sum+=c;
			a = b;
			b = c;
		}
		System.out.println("Summation is "+sum);
		return c;
	}

}

