import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=979
 * @author Kliver Daniel
 *
 */
public class JollyJumpers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String l;
		while ( (l = br.readLine())!=null && !l.equals("") ) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			String[] line = l.split(" ");
			int n = Integer.parseInt(line[0]);
			for (int i = 0; i < n-1; i++) {
				int a = Integer.parseInt(line[i+1]), b = Integer.parseInt(line[i+2]);
				int c = Math.abs(a-b);
				pq.offer(c);
			}
			int next = 1;
			while ( !pq.isEmpty() && next<n ) {
				if ( pq.peek()==next ) {
					pq.poll();
					next+=1;
				} else
					next += 1;
			}
			sb.append(pq.isEmpty() ? "Jolly":"Not jolly");
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
		br.close();
	}

}
