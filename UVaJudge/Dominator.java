import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3053
 * @author Kliver Daniel
 *
 */
public class Dominator {
	
	static List<Integer>[] adj;
	
	static void dfs(int s, int stop, boolean[] visited) {
		if (s==stop)
			return;
        visited[s] = true;
        for (Integer i : adj[s]) {
			if (!visited[i])
				dfs(i,stop,visited);
		}
	}
	
	static void dfs(int s, boolean[] visited) {
        visited[s] = true;
        for (Integer i : adj[s]) {
			if (!visited[i])
				dfs(i,visited);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(), aux1;
		int T = sc.nextInt();
		for (int k = 1; k <= T; k++) {
			aux1 = new StringBuffer();
			int N = sc.nextInt();
			adj = new ArrayList[N];
			aux1.append("+");
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<Integer>();
				aux1.append("--");
			}
			aux1.deleteCharAt(1);
			aux1.append("+");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (sc.nextInt()==1) { //Cretaing connetions
						adj[i].add(j);
					}
				}
			}
			boolean[] alc1 = new boolean[N],alc2;
			dfs(0,alc1);
			sb.append("Case "+k+":\n");
			for (int i = 0; i < N; i++) {
				sb.append(aux1+"\n");
				alc2 = new boolean[N];
				dfs(0,i,alc2);
				for (int j = 0; j < alc2.length; j++) {
					sb.append("|");
					if (!alc1[j] || alc2[j])
						sb.append("N");
					else
						sb.append("Y");
				}
				sb.append("|\n");
			}
			sb.append(aux1+"\n");
		}
		System.out.print(sb);
		sc.close();
	}

}
