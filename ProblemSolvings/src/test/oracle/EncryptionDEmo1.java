package test.oracle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class EncryptionDEmo1 {
	
	

	public static void main(String[] args) throws InterruptedException  {

		String s = "if man was meant to stay on the ground god would have given us roots";
		String s2 = "chill out";
		String encrypted = encryption(s2);
		System.out.println(encrypted);
		synchronized (args) {
			System.out.println(1);
			args.wait();
			System.out.println(2);
		}
		
	}

	
	
	private static String encryption(String s) {
		
	    s= s.replaceAll("\\s+", "");
	    //System.out.println(s);
	    int len = s.length();
	    double squareRoot = Math.sqrt(len);
	    int r = (int)Math.floor(squareRoot);
	    int c = (int)Math.ceil(squareRoot);
	    while(r *c < len) {
	    	r= r+1;
	    }
	    char arr[][] = new char[r][c];
	    char[] chars = s.toCharArray();
	    int k =0;
	    for(int i=0;i<r;i++) {
	    	for(int j=0;j<c;j++) {
	    		if(k < chars.length) {
		    		arr[i][j] = chars[k++];
	    		}
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int j=0;j<c;j++) {
	    	for(int i=0;i<r;i++) {
	    	   if(arr[i][j] != '\u0000') {
		    	   sb.append(arr[i][j]);
	    	   }	    			    		
	    	}
	    	sb.append(" ");
	    }
		return sb.toString();
	}

}
