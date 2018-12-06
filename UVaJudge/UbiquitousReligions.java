/**
 * @author Kliver Daniel
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1524
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

class UbiquitousReligions {
	
    private int[] parent;
    private int[] rank;
    private int num;

    public UbiquitousReligions(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
        num = n;
    }
    
    public int find(int i) {
        return root(i);
    }

    public int union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return u;
        if (rank[v] < rank[u]) {
            int t = v; v = u; u = t;
        }
        parent[u] = v;
        rank[v] += rank[u];
        rank[u] = -1;
        num--;
        return v;
    }
    
    private int root(int u){
        while (parent[u] != u)
            u = parent[u];
        return u;
    }

    @SuppressWarnings("unused")
    private int root1(int u){
        int p = parent[u];
        if (p == u)
            return u;
        do {
            int p1 = parent[p];
            if (p == p1) {
                u = p;
                break;
            } else {
                parent[u] = p1;
                u = p;
                p = p1;
            }
        } while (true);
        return u;
    }
    
    public int rank(int u){
        return rank[root(u)];
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
		int l = 1;
		while ( !(n == 0 && m == 0)  ) {
			UbiquitousReligions main = new UbiquitousReligions(n);
			while ( m-- > 0 ) {
				String[] l2 = br.readLine().split(" ");
				int i = Integer.parseInt(l2[0]);
				int j = Integer.parseInt(l2[1]);
				main.union(i-1,j-1);
			}
			if ( main.num < 1 )
				main.num = 1;
			System.out.println("Case "+(l++)+": "+main.num);
			line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
		}
		br.close();
	}
}
