package com.orcl.miscelineous;
/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class IndianCurrency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      System.out.println(indianCurrency(234567000));
	}

	private static String indianCurrency(int number) {
		char[] num = Integer.toString(number).toCharArray();		
		StringBuilder sb = new StringBuilder();
		int hundred =0;
		int k=0;
		for(int i= num.length-1;i>=0;i--){			
			if(hundred<3){
				sb.append(num[i]);
				hundred++;
				continue;
			}
			if(k ==0){
				sb.append(",");
				sb.append(num[i]);
				k++;
			}else{
				sb.append(num[i]);
				k=0;
			}		
		}		
		return sb.reverse().toString();
	}

}

