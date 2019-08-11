package test.oracle;
/**
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 * @author ritsarka
 *
 */
public class TimesInWord {

	public static void main(String[] args) {

		System.out.println(timeInWords(11, 46));
		
		    
		  
	}
	static String timeInWords(int h, int m) {

		if(h > 12 || m >59) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if(m <= 30) {
			if(m == 0) {
				sb.append(word(h));
				sb.append(" o' clock");
			}
			if(m > 0) {				
				sb.append(word(m));
				sb.append(" ");
				if(m % 15 != 0) {
					sb.append(m>1?"minutes ":"minute ");
				}
				sb.append("past ");
				sb.append(word(h));
			}
		}else {
			sb.append(word(60-m));
			sb.append(" ");
			if(m % 15 != 0) {
				sb.append(m>1?"minutes ":"minute ");
			}
			sb.append("to ");
			sb.append(word(h+1));
		}
		return sb.toString();

    }
	private static String word(int n) {
		String[] units=
		    {"",
		     "one",
		     "two",
		     "three",
		     "four",
		     "five",
		     "six",
		     "seven",
		     "eight",
		     "nine"
		    };
		    String[] teen=
		   {"ten",
		    "eleven",
		    "twelve",
		    "thirteen",
		    "fourteen",
		    "fifteen",
		    "sixteen",
		    "seventeen",
		    "eighteen",
		    "nineteen"
		   };
		   String[] tens=
		  { 
		    "",
			"",	  
		    "twenty",
		    "thirty",
		    "forty",
		    "fifty",
		    "sixty",
		    "seventy",
		    "eighty",
		    "ninety"
		  };
		if(n %15 ==0) {
			return n/15 == 1 ? "quarter" : "half";
		}
		if(n > 0 && n < 10) {
			return units[n];
		}else if(n > 9 && n < 20) {
			return teen[n-10];
		}else if(n > 19 && n < 100) {
			int rem = n%10;
			int firstDigit = n-rem;
			return tens[firstDigit/10]+" "+units[rem];			
		}
		return null;
		
	}

}
