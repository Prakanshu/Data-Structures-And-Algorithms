import java.util.*;

public class DetectCycleInUndirectedGraph {
	
// DFS Approach	
// we add a one more variable to DFSRec which is parent to track cycle
	
 public static void main(String[] args){
	 
	 int vertex=3;
	 int source=0;
	 
	 ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	 for(int i =0;i<vertex;i++){
		 graph.add(new ArrayList<Integer>());
	 }
	 addEdge(graph,0,1);
	// addEdge(graph,0,2);
	 addEdge(graph,1,2);
	
	 

	
	 boolean isCycle=DFS(graph,source);
	 System.out.println("Is Cycle "+ isCycle);
	 
	 
 }
 
 public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s , int r){
	 graph.get(s).add(r);
	 graph.get(r).add(s);
	 
 }
 
 public static boolean DFS(ArrayList<ArrayList<Integer>> graph, int source){
	 
	 boolean [] visited = new boolean[graph.size()];
	 
	 for(int i =0; i< graph.size();i++){
		 
		 if(visited[i]==false){
			 
			 if(DFSRec(graph,i,visited,-1)==true){
				 return true;
			 }
		 }
	 }
	
	 return false;
	 
 }
 
 public static boolean DFSRec(ArrayList<ArrayList<Integer>> graph, int source, boolean [] visited, int parent){
	 
	 visited[source]=true;
	 
	 for(int v:graph.get(source)){
		 if(visited[v]==false){
			 if(DFSRec(graph,v,visited,source)==true)
				 return true;
			 
		 } else if(v!=parent)
				return true;
		 
	 }
	 
	 return false;
	 
 }
 
 public static void printGraph(ArrayList<ArrayList<Integer>> graph){
	 
	 for(int i =0;i<graph.size();i++){
		 for(int j=0;j<graph.get(i).size();j++){
			 System.out.print(graph.get(i).get(j)+" ");
		 }
		 System.out.println(" ");
	 }
	 
	 System.out.println(" ");
 }
	
	
	
}