/**
 * 
 */
package matrix.util;

/**
 * @author Ritam
 *
 */
public class MatrixUtil {
	
	public static void parse(int [][] a){
		int r = a.length;
		int c = a[0].length;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		int a[][] = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 },
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};
		int b[][] = new int[a.length][a[0].length];
		parse(a);
		parse(b);
		

	}

}
