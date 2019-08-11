/**
 * 
 */
package tree;

/**
 * @author ritsarka
 *
 */
/**
 * The number of BSTs with n nodes different key is called Catalan
Number and is denoted by Cn. For example, there are 2 BSTs with 2 nodes (2 choices for the
root) and 5 BSTs with 3 nodes.

Read
https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
catalan(BST) = 2nCn/n+1
catalan(BT) = (2nCn)*factorial(n)
 *
 */
public class CatalanNumberOfBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 5;
		System.out.println(fact(n));
		System.out.println("catalan of bst "+catalanBST(n));
		System.out.println(" Catalan of Binary tree "+catalanBT(n));
	}
	static int fact(int n) {
		int fact[] = new int[n+1];
		fact[0]=1;
		for(int i=1;i<=n;i++) {
			fact[i] = i*fact[i-1];
		}
		return fact[n];
	}
	static int combination(int n, int r) {
		if(n==r || r==0) {
			return 1;
		}else if((n ==r-1) || (r ==1)){
			return n;
		}else {
			int result =n;
			for(int i=1;i<=(r-1);i++) {
				result *= (n-i);
			}
			return result/fact(r);
		}
	}
	static int catalanBST(int n) {
		return combination(2*n,n)/(n+1);
	}
	static int catalanBT(int n) {
		return combination(2*n,n)*fact(n);
	}

	
	

}
