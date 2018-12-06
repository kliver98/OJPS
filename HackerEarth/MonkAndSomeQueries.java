/**
 * @author Kliver Daniel
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MonkAndSomeQueries {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(), max = new PriorityQueue<Integer>(Collections.reverseOrder());
		int Q = Integer.parseInt(br.readLine().trim());
		while (Q-->0) {
			String line = br.readLine();
			if (line.equalsIgnoreCase("3"))
				sb.append(max.isEmpty() ? "-1\n":max.peek()+"\n");
			else if (line.equalsIgnoreCase("4"))
				sb.append(min.isEmpty() ? "-1\n":min.peek()+"\n");
			else {
				int v = Integer.parseInt(line.split(" ")[1]);
				if (line.split(" ")[0].equalsIgnoreCase("1")) {
					max.offer(v);
					min.offer(v);
				} else { //Eliminar
					if (max.contains(v)) {
						min.remove(v);
						max.remove(v);
					} else
						sb.append("-1\n");
				}
					
			}
		}
		System.out.print(sb);
		br.close();
	}

}
