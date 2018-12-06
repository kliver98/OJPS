import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 
 * @author Kliver Daniel
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=&problem=4388
 */
 class LargestSumGame {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ( (line = br.readLine()) != null ) {
			String[] c = line.split(" ");
			int[] nms = new int[c.length];
			for (int i = 0; i < nms.length; i++)
				nms[i] = Integer.parseInt(c[i]);
			System.out.println(maxSuma(nms));
		}
		br.close();
	}
	
	static int maxSuma(int[] nms) {
		int max = 0, actual = 0;
		for (int i : nms) {
			max = Math.max(actual,max);
			actual = ( i > actual+i ) ? i : actual+i;
		}
		return Math.max(actual, max);
	}

}
