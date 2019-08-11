/**
 * 
 */
package number.reccursive;

/**
 * @author Ritam
 *
 */
public class AnyNumberToDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Convert conv = new Convert();
       //System.out.println(conv.toNumber(4,2));
       //System.out.println(conv.toDecimal(100,2));
       System.out.println(conv.toNumber(12,8));
       System.out.println(conv.binarytoDecimal(14,8));
       
	}

}
class Convert {	
	public String toNumber(int decimal,int radix){
		String bin = "";
		if(decimal <=0){
			return bin;
		}else{
		   bin = toNumber(decimal/radix,radix)+decimal%radix;
		   return bin;	
		}
		
	}
	public int binarytoDecimal(int binary,int radix){
		int decimal =0;
		int p=0;
		while(binary != 0){
			decimal += ((binary%10)*Math.pow(radix, p));
			p++;
			binary = binary/10;
		}
		return decimal;
	}
	
	
}
