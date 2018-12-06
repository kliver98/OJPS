/**
 * @author Kliver Daniel
 */
import java.util.LinkedList;
import java.util.Scanner;

public class UnreachableNodes {

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
		void dfs(int s, boolean[] visited) {
	        visited[s] = true;
	        for (int i : adj[s]) {
				if (!visited[i])
					dfs(i,visited);
			}
		}
		int count(int h) {
			boolean[] visited = new boolean[V];
			dfs(h,visited);
			int cont = 0;
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i])
					cont++;
			}
			return cont;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		Graph g = new Graph(N);
		while (M-->0) {
			int v=sc.nextInt()-1,w=sc.nextInt()-1;
			g.addEdge(v,w);
		}
		int h = sc.nextInt()-1;
		System.out.println(g.count(h));
		sc.close();
	}

}
