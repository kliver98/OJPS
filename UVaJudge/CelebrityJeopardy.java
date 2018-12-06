import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 
 * @author Kliver Daniel
 *
 */
public class CelebrityJeopardy {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine())!=null && !line.isEmpty()) {
			System.out.println(line);
		}
		br.close();
	}

}
