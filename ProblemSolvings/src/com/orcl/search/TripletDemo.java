package com.orcl.search;
import java.util.Arrays;

public class TripletDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr1[] = {5,1,3,4,7};
      System.out.println(" no of subarrays for counttriplet1 "+countTriplet1(arr1, 12));
     // System.out.println(" no of subarrays for counttriplet2 "+countTriplet2(arr1, 12));
      
	}
	/**
	 * arr = 5,1,3,4,7
	 * sum = 12
	 * count no of triplets < 12
	 * output 4
	 * (1, 3, 4), (1, 3, 5), (1, 3, 7) and  (1, 4, 5)
	 * 
	 */
   static int countTriplet1(int a[],int sum){
	   Arrays.sort(a);
	   int n = a.length;
	   int ans =0;
	   for(int i=0;i<n-2;i++){
		   int j = i+1;
		   int k = n-1;		  
		   while(j<k){
			   if(a[i]+a[j]+a[k] >= sum){
				   k--;
			   }else{
				   ans += (k-j);
				   j++;
			   }
		   }   
		   
	   }
	   return ans;
   }
   
   /**
	 * arr = 5,1,3,4,7
	 * sum = 12
	 * count no of triplets > 12
	 * output 4
	 * (1, 5, 7), (3,4,7), (3, 5, 7) and  (4, 5, 7)
	 * 
	 */
   static int countTriplet2(int a[],int sum){
	   int n = a.length;
	   int ans =0;
	   Arrays.sort(a);
	   for(int i=0;i<n-2;i++){		
		int j =i+1;
		int k = j+1;
		if(j >= n || k >= n){
			return ans;
		}else{
			while(k<n){
			  if(a[i]+a[j]+a[k] <= sum){
				  k++;
			  }else{
				  ans += n-k; 
				  break;
			  }
			}			
			while(j<n && k<n){
				  if(a[i]+a[j]+a[k] <= sum){
					  j++;
					  k = j+1;
				  }else{
					  ans += n-k; 
					  break;
				  }
			}
												
		}		
	   }	   
	   return ans;
   }
}
