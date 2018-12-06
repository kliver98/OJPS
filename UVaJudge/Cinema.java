import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3961
 * @author Kliver Daniel
 *
 */
class Cinema {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] l = br.readLine().split(" ");
		int r = Integer.parseInt(l[0]),c = Integer.parseInt(l[1]);
		while ( r!=0 && c!=0 ) {
			boolean entro = false;
			boolean[][] theater = new boolean[r][c+1];
			int p = Integer.parseInt(br.readLine());
			while ( p-- > 0 ) {
				String[] line = br.readLine().split(" ");
				String signo = line[1];
				int row = line[0].charAt(0)-'A';
				int column = Integer.parseInt(line[0].substring(1));
				if ( signo.equals("-") ) {
					column -= 1;
				}
				theater[row][column] = true;
			}
			int z = Integer.parseInt(br.readLine());
			ArrayList<Pair> pairs = new ArrayList<Pair>();
			while ( z-- > 0 ) {
				String line = br.readLine();
				char row = line.charAt(0);
				int column = Integer.parseInt(line.substring(1));
				pairs.add(new Pair(row,column));
			}
			Collections.sort(pairs);
			for (int i = 0; i < pairs.size() && !entro; i++) {
				Pair a = pairs.get(i);
				int row = a.row-'A';
				int column = a.column;
				if ( !theater[row][column] ) { //La puede colocar aquí - derecha
					theater[row][column] = true;
				} else if ( !theater[row][column-1] ) { //Izquierda
					theater[row][column-1] = true;
				} else {
					entro = true;
				}
			}
			System.out.println(entro ? "NO":"YES");
			l = br.readLine().split(" ");
			r = Integer.parseInt(l[0]);
			c = Integer.parseInt(l[1]);
		}
		br.close();

	}
	
	static class Pair implements Comparable<Pair> {
		char row;
		int column;
		public Pair(char r, int c) {
			row = r;
			column = c;
		}
		@Override
		public int compareTo(Pair e) {
			int k = e.row-row;
			if ( k == 0 )
				k = e.column-column;
			return k;
		}
	}

}
