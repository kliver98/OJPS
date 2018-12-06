/**
 * @author Kliver Daniel
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class SearchingQuickly {
	
	static int ignore_count;
	static int phrases_count;
	static PriorityQueue<Pair> parejas;
	
	static class Pair implements Comparable<Pair> {
		String word;
		String phrase;
		Integer priority,index_apper;
		public Pair( String w, String p, int priority, int index_apper ) {
			word = w;
			phrase = p;
			this.priority = priority;
			this.index_apper = index_apper;
		}
		@Override
		public int compareTo(Pair o) {
			int k = word.compareTo(o.word);
			if (k == 0) {
				k = index_apper.compareTo(o.index_apper);
				if ( k==0 ) {
					k = priority.compareTo(o.priority);
				}
			}
			return k;
		}
		@Override
		public String toString() {
			return phrase;
		}
	}
	static class P{
		ArrayList<String> words = new ArrayList<String>();
		int index_apper;
		public P(String phrase, int index_apper) {
			String[] p = phrase.split(" ");
			for (int i = 0; i < p.length; i++) {
				words.add(p[i]);
			}
			this.index_apper = index_apper;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		ArrayList<String> ignore = new ArrayList<String>(50);
		ArrayList<P> ps = new ArrayList<P>(200);
		boolean ya = false;
		parejas = new PriorityQueue<Pair>();
		while ( (line = br.readLine()) != null && !line.equals("") ) {
			if ( line.equals("::") ) {
				ya = true;
				continue;
			}
			if ( !ya ) {
				ignore.add(line);
				ignore_count++;
			} else {
				ps.add(new P(line,phrases_count));
				phrases_count++;
			}
		}
		for (int i = 0; i < phrases_count; i++) {
			for (int j = 0; j < ps.get(i).words.size(); j++) {				
				calcular(ignore,ps.get(i),j);
			}
		}
		while ( !parejas.isEmpty() ) {
			System.out.print(parejas.poll().phrase+"\n");
		}
		br.close();

	}
	
	static void calcular(ArrayList<String> ignore,P phrase, int index) {
		
		String rsl = "",mainWord = "";
		boolean cond = false;
		int j = 0;
		for (int i = index; i < phrase.words.size() && !cond; i++) {
			String pal = phrase.words.get(i);
			int size = pal.length(), l = phrase.words.size()-1;
			for (String str : ignore) {
				int size2 = str.length();
				if ( size2!=size )
					continue;
				cond = pal.equalsIgnoreCase(str);
				if ( cond )
					break;
			}
			
			if ( cond ) { //no debo cambiar
				rsl += pal.toLowerCase();
				if ( i<l )
					rsl += " ";
			} else { //Si por mayusculas
				mainWord += pal.toUpperCase();
				rsl += mainWord;
				if ( i<l )
					rsl += " ";
				cond = true;
			}
			j++;
		}
		String aux = "";
		for (int i = 0; i < index && !mainWord.equals(""); i++) {
			aux += phrase.words.get(i).toLowerCase()+" ";
		}
		aux += rsl;
		rsl = aux;
		for (int i = j+index; i < phrase.words.size() && !mainWord.equals(""); i++) {
				rsl += phrase.words.get(i).toLowerCase();
			if ( i < phrase.words.size()-1 ) {
				rsl +=" ";
			}
		}
		if ( !mainWord.equals("") )
			parejas.offer(new Pair(mainWord,rsl,index,phrase.index_apper));
		
	}

}