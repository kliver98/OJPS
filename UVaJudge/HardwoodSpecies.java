import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1167
 * @author Kliver Daniel
 *
 */
public class HardwoodSpecies {
	
	static class HSPair implements Comparable<HSPair> {
		String specie = "";
		String percentage = "";
		public HSPair(String s, int value, int total) {
			specie = s;
			double valor = ((double)value/(double)total)*100;
			String copy = String.format("%.4f", valor);
			for (int i = 0; i < copy.length(); i++) {
				boolean c = copy.charAt(i)==',';
				if ( c )
					percentage += ".";
				else
					percentage += copy.charAt(i);
			}
		}
		@Override
		public int compareTo(HSPair o) {
			int l = specie.compareTo(o.specie);
			return l;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		while ( n-- > 0 ) {
			String line = br.readLine();
			PriorityQueue<HSPair> info = new PriorityQueue<HSPair>();
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			int totalDatos = 0;
			while ( line!=null && !line.equals("") ) {
				
				int value = 1;
				totalDatos+=1;
				if ( map.get(line) != null )
					value = map.get(line)+1;
				map.put(line,value);
				
				line = br.readLine();
			}
			
			for (String key : map.keySet()) {
				info.offer(new HSPair(key,map.get(key),totalDatos));
			}
			while ( !info.isEmpty() ) {
				HSPair e = info.poll();
				sb.append(e.specie+" "+e.percentage+"\n");
			}
			if ( n!= 0 )
				sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
