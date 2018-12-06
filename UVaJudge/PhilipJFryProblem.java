import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * @author Kliver Daniel
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3746
 */
class PhilipJFryProblem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while ( (n = sc.nextInt()) != 0 ) {
			Viaje[] viajes = new Viaje[n];
			for (int i = 0; i < n; i++) {
				int t = sc.nextInt(), b = sc.nextInt();
				viajes[i] = new Viaje(t,b);
			}
			for (int i = n-1; i >= 0; i--) {
				Viaje act = viajes[i];
				if ( act.b > 0 ) {
					ArrayList<Viaje> copy = new ArrayList<Viaje>();
					for (int j = i+1; j < viajes.length; j++) {
						Viaje copy2 = viajes[j];
						if ( !copy2.ya )
							copy.add(copy2);
					}
					Collections.sort(copy);
					for (int j = 0; j < Math.min(copy.size(),act.b); j++)
						copy.get(j).ya = true;
				}
			}
			int total = 0;
			for (Viaje viaje : viajes)
				total += (viaje.ya) ? viaje.t/2:viaje.t;
			System.out.println(total);
		}
		sc.close();
	}
	
	static class Viaje implements Comparable<Viaje> {
		int t,b;
		boolean ya;
		public Viaje(int t, int b) {
			this.t = t;
			this.b = b;
			ya = false;
		}
		@Override
		public int compareTo(Viaje otro) {
			return otro.t-t;
		}
	}

}
