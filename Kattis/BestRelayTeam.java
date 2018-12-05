/**
 * @author Kliver Daniel
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class BestRelayTeam {

	static class Player implements Comparable<Player> {
		String name;
		double f;
		double s;
		public Player(String n, double firstL, double secondL) {
			name = n;
			f = firstL;
			s = secondL;
		}
		@Override
		public int compareTo(Player a) {
			double k = s-a.s;
			int r = 0;
			if ( k > 0 )
				r = 1;
			else if ( k < 0 )
				r = -1;
			return r;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		ArrayList<Player> players = new ArrayList<Player>();
		while ( T-- > 0 ) {
			String[] line = br.readLine().split(" ");
			String n = line[0];
			double firstL = Double.parseDouble(line[1]);
			double secondL = Double.parseDouble(line[2]);
			players.add(new Player(n,firstL,secondL));
		}
		Collections.sort(players);
		int iMenor = 0;
		double cont = 0, contA = Double.MAX_VALUE;
		for (int i = 0; i < players.size(); i++) {
			cont = players.get(i).f;
			int k = -1;
			for (int j = 0; j < 3; j++) {
				k += 1;
				if (i==j)
					k += 1;
				cont += players.get(k).s;
			}
			if ( cont < contA ) {
				contA = cont;
				iMenor = i;
			}
		}
		ArrayList<Player> ps = new ArrayList<Player>();
		int k = 0;
		cont = players.get(iMenor).f;
		ps.add(players.get(iMenor));
		for (int i = 0; i < 3; i++) {
			if (i==iMenor)
				k += 1;
			cont += players.get(k).s;
			ps.add(players.get(k));
			k+=1;
		}
		sb.append(cont+"\n");
		while ( !ps.isEmpty() ) {
			sb.append(ps.get(0).name+"\n");
			ps.remove(0);
		}
		System.out.print(sb.toString());
		br.close();
	}

}