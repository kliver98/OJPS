import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2499
 * @author Kliver Daniel
 *
 */
public class Dominos {

	static List<Integer>[] G;
	static int N;
	static Stack<Integer> s;
	static boolean[] visited;
	
	static void dfs(int i) {
		visited[i] = true;
		for (Integer v : G[i]) {
			if ( !visited[v] )
				dfs(v);
		}
		s.push(i);
	}
	
	static void dfs2(int i) {
		visited[i] = true;
		for (Integer v : G[i]) {
			if ( !visited[v] )
				dfs(v);
		}
	}
	
	static void top() {
		visited = new boolean[N];
		for (int i = N-1; i >= 0; i--) {
			if (!visited[i])
				dfs(i);
		}
	}
	
	static int SCC() {
		top();
		visited = new boolean[N];
		int cont = 0;
		while( !s.isEmpty() ) {
			int f = s.pop();
			if ( !visited[f] ) {
				cont++;
				dfs2(f);
			}
		}
		return cont;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		while ( t-- > 0 ) {
			
			String[] l = br.readLine().split(" ");
			int n = Integer.parseInt(l[0]), m = Integer.parseInt(l[1]);
			G = new ArrayList[n];
			N = n;
			for (int i = 0; i < n; i++) {
				G[i] = new ArrayList<Integer>();
			}
			while ( m-- > 0 ) {
				String[] ln = br.readLine().split(" ");
				int a = Integer.parseInt(ln[0])-1, b = Integer.parseInt(ln[1])-1;
				G[a].add(b);
			}
			s = new Stack<Integer>();
			sb.append(SCC()+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
