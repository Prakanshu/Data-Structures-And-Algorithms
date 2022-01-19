import java.util.*;

/*
Given a disconnected graph, print BFS
and
Counting Connected Component in an Undirected Graph
*/


public class BFSTraversalForDisconnectedGraph{
	
	public static void main(String[]args){
		
		int vertex=7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i =0;i<vertex;i++){
			adj.add(new ArrayList<Integer>());
			
		}
		
		
		
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,3);
		addEdge(adj,2,3);
	
		addEdge(adj,4,5);
		addEdge(adj,4,6);

		BFSDisconnected(adj,7);
}
   public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
	   // since its undirected graph, we are adding edge both ways
	   adj.get(u).add(v);
	   adj.get(v).add(u);
   }
   public static void printGraph(ArrayList<ArrayList<Integer>> adj){
	   for(int i =0;i<adj.size();i++){
			
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(adj.get(i).get(j)+ " ");
			}
			System.out.println();
			
		}
   }
   
   public static void BFS(ArrayList<ArrayList<Integer>> adj,int source,boolean[] visited){
	   Queue<Integer> queue= new LinkedList<>();
	   queue.add(source);
	   visited[source] = true;
	   while(!queue.isEmpty()){
		    int u = queue.poll();
			System.out.print(u+" ");
		    for(int v: adj.get(u)){
				if(visited[v]==false){
					visited[v]=true;
					queue.add(v);
				}
			}
	   }  
	   
   }
   
   public static void BFSDisconnected(ArrayList<ArrayList<Integer>> adj,int vertex){
	   boolean [] visited= new boolean[vertex+1];
	   int count=0;
	   for(int i =0;i<vertex;i++)
	   {
		   if(visited[i]==false){
			   BFS(adj,i,visited);
			   count++;
		   }
	   }
	   System.out.println("");
	   System.out.print("No of connected component in undirected graph "+count);
   }
}