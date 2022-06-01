import java.util.*;


/*
Given a connected and undirected graph with a source , print DFS
*/
public  class DFSConnectedGraph {

	public static void main(String[] args){
	 
	 int vertex =5;
	 int source=0;
	 ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	 for(int i =0;i<vertex;i++){
		 adj.add(new ArrayList<Integer>());
		 
	 }
	 
	 addEdge(adj,0,1);
	 addEdge(adj,0,2);
	 addEdge(adj,1,3);
	 addEdge(adj,1,4);
	 addEdge(adj,2,3);
	 addEdge(adj,3,4);
	 printGraph(adj);
	 
	 System.out.println();
	 DFS(adj,source);
	
	
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u , int v){
		
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
    
	public static void printGraph(ArrayList<ArrayList<Integer>> adj){
		
		for(int i=0;i<adj.size();i++)
		{
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j) + " ");
				
			}
			
			System.out.println();
		}
		
	}
	
	public static void DFS(ArrayList<ArrayList<Integer>> adj,int source){
		boolean [] visited = new boolean[adj.size()];
		
		DFSRecurr(adj,source, visited);
		
		
	}
	
	public static void DFSRecurr(ArrayList<ArrayList<Integer>> adj,int source, boolean[] visited){
		
		visited[source]=true;
		System.out.print(source+" ");
		for(int v:adj.get(source)){
			if(visited[v]==false){
				DFSRecurr(adj,v,visited);
				
			}
			
		}
		
	}

}