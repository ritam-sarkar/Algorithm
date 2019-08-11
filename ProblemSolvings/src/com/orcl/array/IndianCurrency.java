package com.orcl.array;
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
		// TODO Auto-generated method stub
      System.out.println(indianCurrency(234567));
	}

	private static String indianCurrency(int number) {
		char[] num = Integer.toString(number).toCharArray();		
		StringBuilder sb = new StringBuilder();
		int j =0;
		int k=0;
		for(int i= num.length-1;i>=0;i--){			
			if(j<3){
				sb.append(num[i]);
				j++;
			}else if(k<2){
				if(k ==0){
					sb.append(",");
					sb.append(num[i]);
					k++;
				}else{
					sb.append(num[i]);
					k=0;
				}
				
			}
		}	
		
		return sb.reverse().toString();
	}

}

