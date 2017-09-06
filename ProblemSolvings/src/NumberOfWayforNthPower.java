/**
 * n = 2, x =10
 * 1^2 + 3^2 = 10
 * 
 * n = 3, x = 100
 * 1^3 + 2^3 + 3^3 + 4^3 = 100
 * 
 * @author Ritam
 *
 */
public class NumberOfWayforNthPower {

	public static void main(String[] args) {

		int x =100;
		int n = 2;
		System.out.println(pow(2,10));
		System.out.println(checkRecursive(x,n,1,0));
	}
	static int checkRecursive(int x, int n, int curr_num,int curr_sum)
      {	
			
			int results = 0;
			
			int p = (int) Math.round(Math.pow(curr_num, n));
			while(p+curr_sum < x){
				 results += checkRecursive(x, n, curr_num+1,p+curr_sum);
				 curr_num++;
				 p = (int) Math.round(Math.pow(curr_num, n));
			}
			
			if (p + curr_sum == x)
			 results++;
			
			// Return the final result
			return results;
      }
	static int pow(int n,int r){
		int result =0;
		if(r==0){
			result = 1;
		}
		if(r>1){
			if(r%2 == 0){
				result = pow(n,r/2)*pow(n,r/2);
			}else{
				result = n*pow(n,r/2)*pow(n,r/2);
			}			
		}else if(r ==1){
			result = n;
		}
		return result;
	}

}
