/**
 * 
 */
package matrix;

/**
 * @author Ritam
 *
 */
public class ShortestPathInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       Position p1 = new Position(0,0);
       Position p2 = new Position(4, 4);
       int mat[][] = new int[5][5];
       findShortestPath(mat,p1,p2);
		
	}

	public static void findShortestPath(int[][] mat, Position p1, Position p2) {
		if(!p1.isValid(mat) || !p2.isValid(mat)){
			System.out.println("not valid position ");
			return;
		}
		
		
		
	}
	private static boolean isValidMove(int[][] mat,int r,int c){
		int m = mat.length;
		int n = mat[0].length;
		if(r>=0 && r<m && c>=0 && c<n){
			return true;
		}
		return false;		
	}

}
class Position {
	int row;
	int column;
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	public boolean isValid(int[][] a){
		int r = a.length;
		int c = a[0].length;
		if(this.row<r && this.column<c){
			return true;
		}
		return false;
	}
}
