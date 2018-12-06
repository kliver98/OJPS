/**
 * @author Kliver Daniel
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class breadth_first_search_introduction {

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
		int niveles(int s, int x) {
			int cont = 0;
			int[] level = new int[V];
			boolean[] vis = new boolean[V];
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.offer(s);
	        level[ s ] = 0 ;
	        vis[ s ] = true;
	        boolean salir = false;
	        while(!q.isEmpty() && !salir) {
	            int p = q.poll();
	            for(int i = 0;i < adj[p].size() && !salir; i++) {
	                if(vis[ adj[p].get(i)] == false) {
	                	int l = level[p]+1;
	                	if (l>x)
	                		salir = true;
	                	if (l==x)
	                		cont++;
	                    level[adj[p].get(i)] = l;                 
	                     q.offer(adj[p].get(i));
	                     vis[adj[p].get(i)] = true;
	                }
	            }
	        }
	        return cont;
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Graph g = new Graph(N);
		while (N-->1)
			g.addEdge(sc.nextInt()-1,sc.nextInt()-1);
		System.out.println(g.niveles(0,sc.nextInt()-1));
		sc.close();
	}

}
