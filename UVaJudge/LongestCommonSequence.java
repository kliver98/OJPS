import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonSequence {
	
	static int[][] matriz;
	
	static int LCS(String p, String q,int n, int m) {
		if ( matriz[n][m] != 0 )	return matriz[n][m];
		int result = 0;
		if ( n==0 || m==0 )
			result = 0;
		else if ( p.charAt(n-1) == q.charAt(m-1) )
			result =  1 + LCS(p,q,n-1,m-1);
		else if ( p.charAt(n-1) != q.charAt(m-1) )
			result = Math.max(LCS(p,q,n-1,m),LCS(p,q,n,m-1));
		matriz[n][m] = result;
		return result;
	}
	
	static void init() {
		matriz = new int[1000][1000];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String p = "",q="";
		while ( (p = br.readLine()) != null ) {
			q = br.readLine();
			init();
			sb.append(LCS(p,q,p.length(),q.length())+"\n");
		}
		br.close();
		System.out.print(sb.toString());
	}

}
