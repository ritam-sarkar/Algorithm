import java.util.LinkedList;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindLoopInDirectedGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
		Graph g1 = new Graph(4);
		g1.addEdge(0, 1);
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.addEdge(1, 2);
		g1.addEdge(3, 3);
		if(g1.isCyclic()){
			System.out.println(" graph is cyclick");
		}else{
			System.out.println(" graph is not cyclick ");
		}
		

	}
	static class Graph{
		private int V;
		private LinkedList<Integer>[] adj = null;
		private int visited[]; 
		private int recStack[];
		public  Graph(int n){
			V=n;
			adj = new LinkedList[V];
			for(int i=0;i<V;i++){
				adj[i] = new LinkedList<Integer>();
			}
			visited = new int[V];
			recStack = new int[V];
		}
		public void addEdge(int v,int w){
			adj[v].add(w);
		}
		boolean isCyclic(){
			for(int u=0;u<V;u++){
			  if(visited[u]==0){
				return isCyclicUtil(u,visited,recStack); 
			  }
			}
			return false;
		}
		private boolean isCyclicUtil(int v, int[] visited, int[] recStack) {
			visited[v]=1;
			recStack[v]=1;
			for(int i : adj[v]){
				if(visited[i] == 0 && isCyclicUtil(i, visited, recStack)){
					return true;
				}else if(recStack[i]==1){
					return true;
				}				
			}
			recStack[v]=0;
			return false;
		}
	}

}
