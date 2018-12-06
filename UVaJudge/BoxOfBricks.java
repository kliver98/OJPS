import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=532
 * @author Kliver Daniel
 *
 */
public class BoxOfBricks {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0, cont = 1;
		StringBuilder sb = new StringBuilder();
		while ( (N = Integer.parseInt(br.readLine().trim()))!=0 ) {
			int[] nms = new int[N];
			String[] l = br.readLine().split(" ");
			int media = N, sumaDatos = 0, total = 0;
			for (int i = 0; i < N; i++) {
				nms[i] = Integer.parseInt(l[i]);
				sumaDatos += nms[i];
			}
			media = sumaDatos/N;
			Arrays.sort(nms);
			int i = 0;
			while (true) {
				if ( i>=nms.length || nms[i]>media) {
					break;
				} else {
					total += media-nms[i];
					i++;
				}
			}
			sb.append("Set #"+cont+"\nThe minimum number of moves is "+total+"."+"\n\n");
			cont++;
		}
		System.out.print(sb.toString());
		br.close();
	}

}
