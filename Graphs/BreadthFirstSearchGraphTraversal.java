import java.util.*;


/*
 Given an undirectedGraph and source vertex,print BFS
*/
public class BreadthFirstSearchGraphTraversal{
	
	
	public static void main(String[] args){
		
		
	    int vertex =5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertex);
		
		for(int i =0;i<vertex;i++){
			adj.add(new ArrayList<Integer>());
			
		}
		
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		addEdge(adj,2,3);
		breadthFirstSearch(adj,vertex,0);
	}	
	
	public static void addEdge(ArrayList<ArrayList<Integer>>adj,int u, int v){
		
		adj.get(u).add(v);
		adj.get(v).add(u);
		
	}
	
	public static void breadthFirstSearch( ArrayList<ArrayList<Integer>>adj, int vertex, int source){
		
		
		Boolean [] visited = new Boolean[vertex];
		
		for(int i = 0; i < vertex; i++) 
    		visited[i] = false; 
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[0]=true;
		
		while(!queue.isEmpty()){
			int u=queue.poll();
			System.out.print(u +" ");
			for(int v:adj.get(u)){
				if(visited[v]==false){
					visited[v]=true;
					queue.add(v);
					
				}
				
			}
			
		}
		
		
	}
	
	public static void printGraph( ArrayList<ArrayList<Integer>>adj){
		
		for(int i =0;i<adj.size();i++){
			
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+ " ");
			}
			System.out.println();
			
		}
		
	}
	
}