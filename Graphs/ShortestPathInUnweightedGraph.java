import java.util.*;
import java.lang.*;
class ShortestPathInUnweightedGraph{
	
	
	public static void main(String[]args){
		
		int vertex=4;
		int source=0;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i =0;i<vertex;i++){
			graph.add(new ArrayList<Integer>());
		}
		
		addEdge(graph,0,1);
		addEdge(graph,0,2);
		
		addEdge(graph,1,2);
		addEdge(graph,1,3);
		
		addEdge(graph,2,3);
		
		printGraph(graph);
		System.out.println("");
		
		int [] distance = shortestPath(graph,source,vertex); // from the source
		for(int f:distance){
			System.out.print(f+" ");
		}
		
		
		
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s,int r){
		
		graph.get(s).add(r);
		graph.get(r).add(s);
	}
	
	public static void printGraph(ArrayList<ArrayList<Integer>> graph){
		
		for(int i =0;i<graph.size();i++){
			for(int j=0;j<graph.get(i).size();j++){
				System.out.print(graph.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static int[] shortestPath(ArrayList<ArrayList<Integer>> graph,int source,int vertex){
		
		int[] dist = new int[vertex];
		for(int i =0; i<dist.length;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[source]=0;
		boolean[] visited = new boolean[vertex];
		visited[source]=true;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			int u= queue.poll();
			
			for(int v: graph.get(u)){
				if(visited[v]==false){
					dist[v]=dist[u]+1;
					visited[v]=true;
					queue.add(v);
				}
				
			}
		}
		return dist;
	}
}