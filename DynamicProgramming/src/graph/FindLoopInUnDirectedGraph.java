
/**
 * 
 *   1---------------0--------------3
 *   |               |              |
 *   |               |              |
 *   |               |              |
 *   2----------------              4
 *   
 *  one connection is from 0 to 2
 *  
 * 
 */


package graph;

import java.util.LinkedList;

public class FindLoopInUnDirectedGraph {

	public static void main(String[] args) {
		 Graph g1 = new Graph(5);
		    g1.addEdge(1, 0);		   
	        g1.addEdge(0, 2);
	        g1.addEdge(1, 2);
	        g1.addEdge(0, 3);
	        g1.addEdge(3, 4);
	     if(g1.isCyclic()){
	    	 System.out.println(" this graph has a loop");
	     }else{
	    	 System.out.println(" this graph has no loop");
	     }
	        

	}
	
	static class Graph{
		 private int V;   // No. of vertices
		 private LinkedList<Integer> adj[]; // Adjacency List Represntation		 
		    // Constructor
		    Graph(int v) {
		        V = v;
		        adj = new LinkedList[v];
		        for(int i=0; i<v; ++i)
		            adj[i] = new LinkedList();
		    }
		 
		    // Function to add an edge into the graph
		    void addEdge(int v,int w) {
		        adj[v].add(w);
		        adj[w].add(v);
		    }
		    boolean isCyclic(){
		    	int[] visited = new int[V];
		    	for(int u=0;u< V;u++){
		    		if(visited[u]==0){
		    			if(isCyclicUtil(u,visited,-1)){
			    			return true;
			    		}
		    		}		    		
		    	}
		    	return false;	
		    }

			private boolean isCyclicUtil(int v,int[] visited,int parent) {
				visited[v]=1;
				for(int i : adj[v]){
					if(visited[i]==0 && isCyclicUtil(i, visited, v)){						
					    return true;
					}else if(i != parent){
						return true;
					}
					
				}
				return false;
			}
	}

}
