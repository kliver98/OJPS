import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
/**
 * 
 * @author Kliver Daniel
 *
 */
public class LanguageDetection {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("HELLO","ENGLISH");
		map.put("HOLA","SPANISH");
		map.put("HALLO","GERMAN");
		map.put("BONJOUR","FRENCH");
		map.put("CIAO","ITALIAN");
		map.put("ZDRAVSTVUJTE","RUSSIAN");
		String line = "";
		int i = 1;
		while (!(line = br.readLine()).equals("#")) {
			String str = map.get(line)==null ? "UNKNOWN":map.get(line);
			sb.append("Case "+i+": "+str+"\n");
			i++;
		}
		System.out.print(sb);
		br.close();
	}

}
