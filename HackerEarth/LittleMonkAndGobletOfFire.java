/**
 * @author Kliver Daniel
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LittleMonkAndGobletOfFire {
	
	static class Pair {
		Integer x;
		LinkedList<Integer> datos;
		public Pair(Integer a, Integer b) {
			datos = new LinkedList<Integer>();
			x = a;
			add(b);
		}
		boolean isEmpty() {
			return datos.isEmpty();
		}
		void add(Integer y) {
			datos.add(y);
		}
		String get() {
			return x+" "+datos.removeFirst();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int Q = Integer.parseInt(sc.nextLine().trim());
		ArrayList<Pair> s = new ArrayList<Pair>();
		while (Q-->0) {
			String[] line = sc.nextLine().split(" ");
			if (line.length>1) {
				int x = Integer.parseInt(line[1]);
				int y = Integer.parseInt(line[2]);
				boolean seguir = true;
				for (int i = 0; i < s.size() && seguir; i++) {
					if (s.get(i).x==x) {
						s.get(i).add(y);
						seguir = false;
					}
				}
				if (seguir)
					s.add(new Pair(x,y));
			}else {
				sb.append(s.get(0).get()+"\n");
				if (s.get(0).isEmpty())
					s.remove(0);
			}
		}
		System.out.print(sb);
		sc.close();
	}

}
