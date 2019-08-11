/**
 * n = 123, k =3
 * P = 123123123
 * 1+2+3+1+2+3+1+2+3 = 369 => 3+6+9 = 18 => 1+8 =9 
 * answer 9
 * 
 * 
 */
package number.reccursive;

import java.math.BigInteger;

/**
 * @author Ritam
 *
 */
public class SuperDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       System.out.println(superDigit(2,1));
      
		
	}
	public static int superDigit(int n, int k){	
		int s = n*k%9;
		return s == 0 ? 9 : s;
		
	}	

}
