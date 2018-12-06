/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2307
 * @author Kliver Daniel
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SummingDigits {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = "";
		StringBuilder sb = new StringBuilder();
		while ( !(N = br.readLine()).equals("0") ) {
			String[] nms = N.split("");
			int sum = 0;
			for (int i = 0; i < nms.length; i++) {
				sum += Integer.parseInt(nms[i]);
			}
			while (sum>9) {
				nms = (sum+"").split("");
				sum = 0;
				for (int i = 0; i < nms.length; i++) {
					sum += Integer.parseInt(nms[i]);
				}
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
