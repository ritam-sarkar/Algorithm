package array;

/**
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 * @author ritsarka
 *
 */
public class EggdropProblem {

	public static void main(String[] args) {

		int noOfEggs = 2;
		int noOfFloor = 6;
		System.out.println("Minimum number of attempt to find the floor in worst case "+eggDrop(noOfEggs,noOfFloor));
		
	}
	// n = number of eggs
	// f = number of floors
	/**
	 *  maximum because it is to find worst case. 1+ because We need to drop the egg from the xth floor and then reccursively call, depending on
	 *  two case the egg breaks eggFloor[i-1][x-1]  and egg not breaks eggFloor[i][j-x]
	 *  finally need to find the minimum as we need to find the minimum attempt.
	 * @param n
	 * @param f
	 * @return
	 */
	static int eggDrop(int n, int f) {
		
		int res =0;
		if(n <= 0) {
			return 0;
		}
		int eggFloor[][] = new int[n+1][f+1];
		for(int i=0;i<=f;i++) {
			eggFloor[0][i] =0;	
		}
		for(int i=0;i<=f;i++) {
			eggFloor[1][i] = i;
		}
		for(int i=2; i<=n;i++) {
			for(int j =2;j<=f;j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for(int x =1; x<=j;x++) {
					res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
					eggFloor[i][j] = Math.min(res, eggFloor[i][j]);
				}
			}
		}
		return eggFloor[n][f];
		
	}

}
