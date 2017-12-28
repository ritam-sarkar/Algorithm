/**
 * 
 */
package number.reccursive;

/**
 * @author Ritam
 *
 */
public class BitwiseOperatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       samesign();
	}
	private static void samesign(){
		int a = -2;
		int b =3;
		boolean sameSign = (a>=0)^(b<=0);
		System.out.println(a+" "+b+" are of same sign "+sameSign);
	}

}
