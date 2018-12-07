import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=562
 * @author Kliver Daniel
 *
 */
public class SecretResearch {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine().trim());
		while (n-->0) {
			String line = br.readLine();
			if (line.equals("1") || line.equals("4") || line.equals("78"))
				sb.append("+\n");
			else if ( line.charAt(line.length()-2)=='3' && line.charAt(line.length()-1)=='5' )
				sb.append("-\n");
			else if ( line.charAt(0)=='9' && line.charAt(line.length()-1)=='4' )
					sb.append("*\n");
			else
				sb.append("?\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
