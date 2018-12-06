import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4389
 * @author Kliver Daniel
 *
 */
class ReodrnreigLteetrsInWrods {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while ( n-- > 0 ) {
			StringBuilder sb = new StringBuilder();
			String[] diccionario = br.readLine().split(" ");
			String[] words = br.readLine().split(" ");
			for (int i = 0; i < words.length; i++) {
				sb.append(palabra(words[i],diccionario));
				if ( i < words.length-1 )
					sb.append(" ");
			}
			System.out.println(sb.toString());
		}
		br.close();
	}
	
	static String palabra(String word, String[] diccionario) {
		String rst = word;
		for (int i = 0; i < diccionario.length; i++) {
			String a = diccionario[i];
			if ( a.charAt(0) != word.charAt(0) || a.charAt(a.length()-1) != word.charAt(word.length()-1) )
				continue;
			int[] letras = new int[26];
			for (int j = 1; j < word.length()-1; j++)
				letras[word.charAt(j)-'a'] += 1;
			for (int j = 1; j < a.length()-1; j++)
				letras[a.charAt(j)-'a'] -= 1;
			boolean ya = true;
			for (int j = 0; j < letras.length && ya; j++)
				ya = ( letras[j] == 0 );
			if ( ya )
				return a;
		}
		return rst;
	}
	
}