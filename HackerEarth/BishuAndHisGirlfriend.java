/**
 * @author Kliver Daniel
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BishuAndHisGirlfriend {

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
		int N = sc.nextInt();
		Graph g = new Graph(N);
		while (N-->1) {
			int v = sc.nextInt()-1, w = sc.nextInt()-1;
			g.addEdge(v,w);
		}
		int Q = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int id = Integer.MAX_VALUE;
		while (Q-->0) {
			int x = sc.nextInt()-1;
			int v = g.minEdgeBFS(0,x);
			min = Math.min(min,v);
			id = min!=v ? id:Math.min(id,x);
		}
		System.out.println(id+1);
		sc.close();
	}

}
