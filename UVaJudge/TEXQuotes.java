/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=208
 * @author Kliver Daniel
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TEXQuotes { 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		ArrayList<String> data = new ArrayList<String>();	
		while ((line = br.readLine())!=null && !line.isEmpty()) {
			String[] l = line.split(" ");
			StringBuffer str = new StringBuffer();
			boolean estado = false;
			for (int k = 0;k <l.length; k++) {
				String s = l[k];
				char[] c = s.toCharArray();
				for (int i = 0; i < c.length; i++) {				
					if (c[i]==34) {
						estado = !estado;
						str.append(estado ? "``":"''");
					} else
						str.append(c[i]);
				}
				if (k<l.length-1)
					str.append(" ");
			}
			data.add(str.toString());
		}
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i)+" ");
		}
		br.close();
	}

}
