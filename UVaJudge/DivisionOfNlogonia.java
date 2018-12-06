import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2493
 * @author Kliver Daniel
 *
 */
public class DivisionOfNlogonia {
	
	static String calcular(int x, int y, int n, int m) {
		String str = "NO";
		if ( x==n || y==m )
			str = "divisa";
		else {
			if ( x>n && y>m ) {
				str = "NE";
			} else if ( x<n && y<m ) {
				str = "SO";
			} else if ( x>n && y<m ) {
				str = "SE";
			}
		}
		return str+"\n";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while ( !(line = br.readLine().trim()).equals("0") ) {
			int k = Integer.parseInt(line);
			String[] l2 = br.readLine().split(" ");
			int n = Integer.parseInt(l2[0]), m = Integer.parseInt(l2[1]);
			for (int i = 0; i < k; i++) {
				String[] l3 = br.readLine().split(" ");
				int x = Integer.parseInt(l3[0]),y = Integer.parseInt(l3[1]);
				sb.append(calcular(x,y,n,m));
			}
		}
		System.out.print(sb.toString());
		br.close();
	}

}
