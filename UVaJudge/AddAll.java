import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1895
 * @author Kliver Daniel
 *
 */
public class AddAll {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ( true ) {
			int n = Integer.parseInt(br.readLine());
			if ( n==0 )
				break;
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			String[] l = br.readLine().split(" ");
			for (int i = 0; i < l.length; i++) {
				pq.offer(Integer.parseInt(l[i]));
			}
			int val = 0, c = 0;
			while ( !pq.isEmpty() && pq.size() > 1 ) {
				int a = pq.poll(),b=pq.poll();
				c = a+b;
				val += c;
				if ( !pq.isEmpty() )
					pq.offer(c);
			}
			if ( !pq.isEmpty() )
				val += pq.poll();
			System.out.println(val);
		}
		br.close();
		
	}

}
