/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=499
 * @author Kliver Daniel
 *
 */
import java.util.Scanner;

public class Wormholes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int c = sc.nextInt();
		while (c-->0) {
			int n = sc.nextInt(), m = sc.nextInt();
			Graph g = new Graph(n,m);
			for (int i = 0; i < m; i++) {
				g.edge[i].src = sc.nextInt();
				g.edge[i].dest = sc.nextInt();
				g.edge[i].weight = sc.nextInt();
			}
			sb.append(g.isNegCycleBellmanFord(0) ? "possible\n":"not possible\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}

}

class Graph {
    class Edge {
        int src, dest, weight; 
        Edge() { 
            src = dest = weight = 0; 
        } 
    }
  
    int V, E; 
    Edge edge[];
    
    Graph(int v, int e) { 
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    
    boolean isNegCycleBellmanFord(int src) {
        int dist[] = new int[V];
        
        for (int i=0; i<V; ++i)
            dist[i] = Integer.MAX_VALUE;
        
        dist[src] = 0;
        
        for (int i = 1; i <= V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int w = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }
        
        for (int i = 0; i < E; i++) {
            int u = edge[i].src;
            int v = edge[i].dest;
            int w = edge[i].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                return true;
        }
      
        return false;
    }
}