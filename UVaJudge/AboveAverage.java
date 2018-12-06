import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1311
 * @author Kliver Daniel
 *
 */
public class AboveAverage {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String[] l = br.readLine().split(" ");
			int[] nms = new int[Integer.parseInt(l[0])];
			int total = 0;
			for (int i = 1; i <= Integer.parseInt(l[0]); i++) {
				int val = Integer.parseInt(l[i]);
				total += val;
				nms[i-1] = val;
			}
			double media = total/nms.length;
			int totalMedia = 0;
			for (int i = 0; i < nms.length; i++) {
				if ( nms[i]>media )
					totalMedia++;
			}
			media = (double)(100*totalMedia)/nms.length;
			String[] m = (media+"").split("");
			String temp = "";
			int decimales = 0, punto = 0;
			boolean dot = false;
			int k = 0;
			for (int i = 0; i < m.length; i++) {
				temp += m[i];
				if (dot)
					decimales++;
				if (m[i].equals(".")) {
					dot = true;
					punto = i;
				}
				if (decimales>=3) {
					k = i+1;
					break;
				}
			}
			boolean mayor = (decimales>=3 && m.length-1>=k) ? Integer.parseInt(m[k])>=5:false;
			if (mayor) {
				media = Double.sum(media,0.001);
			}
			temp = media+"";
			for (int i = 0; i < 3-decimales; i++) {
				temp += "0";
			}
			String c = "";
			int i = 0, cont = 0;
			m = temp.split("");
			while (true) {
				c += m[i];
				if (i>punto) {
					cont++;
				}
				if (cont==3)
					break;
				i++;
			}
			if (i>0) {
				temp = c;
			}
			sb.append(temp+"%\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
