import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1287
 * @author Kliver Daniel
 *
 */
public class PetersSmokes {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while ( (line=br.readLine())!=null ) {
			int n = Integer.parseInt(line.split(" ")[0]), k = Integer.parseInt(line.split(" ")[1]);
			sb.append(calcular(n,k)+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static int calcular(int n, int k) {
		return n+((n-1)/(k-1));
	}

}
