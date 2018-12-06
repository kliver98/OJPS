/**
 * @author Kliver Daniel
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonkAndTheIslands {
	
	static class Graph {
		private LinkedList<Integer> adj[];
		private int V;
		@SuppressWarnings("unchecked")
		public Graph(int v) {
			V = v;
			adj = new LinkedList[V];
			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<Integer>();
		}
		void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}
		int minEdgeBFS(int u,int v){
			boolean[] visited = new boolean[V]; 
			
			int[] distance = new int[V]; 
			
			Queue<Integer> q = new LinkedList<>(); 
			distance[u] = 0; 
			
			q.add(u);
			visited[u] = true; 
			while (!q.isEmpty()){ 
				int x = q.poll(); 
				for (int i=0; i<adj[x].size(); i++){ 
					if (visited[adj[x].get(i)]) 
						continue;
					distance[adj[x].get(i)] = distance[x]+1; 
					q.add(adj[x].get(i)); 
					visited[adj[x].get(i)] = true; 
				} 
			} 
			return distance[v]; 
		} 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), n = 0,m = 0;
		while (t-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			Graph g = new Graph(n);
			while (m-->0) {
				int v = sc.nextInt()-1,w = sc.nextInt()-1;
				g.addEdge(v, w);
			}
			System.out.println(g.minEdgeBFS(0,n-1));
		}
		sc.close();
		
	}
	
}
