/**
 * 
 */
package com.orcl.dynamicprogramming.matrix;

import matrix.util.MatrixUtil;

/**
 * @author Ritam
 *
 */
public class BinaryMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = 
			 {{1, 0, 0, 0, 1, 1},
              {1, 1, 0, 0, 1, 1},
              {0, 1, 0, 0, 1, 0},
              {0, 1, 1, 1, 1, 1}};
       Point p1 = new Point(0, 0);
       Point p2 = new Point(0, 4);
       MatrixUtil.parse(a);
       System.out.println(" shortest path ");
       MatrixUtil.parse(findMinPath(a, p1, p2));
       
       
	}
	private static int[][] findMinPath(int[][] a, Point p1, Point p2) {
		
		int[][] sol = new int[a.length][a[0].length];
		if(!isValid(a, p1.x,p1.y) || !isValid(a, p2.x,p2.y)){
			System.out.println(" not valid");
		}else{
			if(solveMaze(a,p1.x,p1.y,p2,sol)){
				return sol;
			}else{
				System.out.println("no solution ");
				return sol;
			}
		}		
		return sol;
	}
	private static boolean solveMaze(int[][] a, int x,int y,Point p2, int[][] sol) {
		if(x == p2.x && y == p2.y){
			sol[x][y]=1;
			return true;
		}
		else if(isValid(a,x,y) && !isVisited(sol, x, y)){
			sol[x][y]=1;
			if(solveMaze(a, x+1,y,p2, sol)){
				return true;
			}
			else if(solveMaze(a, x-1,y,p2, sol)){
				return true;
			}
			else if(solveMaze(a, x,y+1,p2, sol)){
				return true;
			}						
			else if(solveMaze(a, x,y-1,p2, sol)){
				return true;
			}			
			sol[x][y]=0;
			return false;			
		}
		return false;
	}
	private static boolean isVisited(int [][] visit, int p1,int p2){
		if(visit[p1][p2] ==1){
			return true;
		}
		return false;
	}
	
	private static boolean isValid(int a[][],int x,int y){
		int r = a.length;
		int c = a[0].length;
		if(x >=0 && x<r && y>=0 && y<c && a[x][y] == 1){
			return true;
		}
		return false;
	}
	private int countMove(int[][] solution,Point p1,Point p2){
		int count=0;
		return count;		
	}

}
class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
