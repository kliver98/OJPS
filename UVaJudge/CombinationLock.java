import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author Kliver Daniel
 */
public class CombinationLock {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String l = "";
		while (!(l = br.readLine()).equals("0 0 0 0")) {
			String[] line = l.split(" ");
			int x = Integer.parseInt(line[0]), uno = Integer.parseInt(line[1]);
			int cont = 1080;
			int dos = Integer.parseInt(line[2]), tres = Integer.parseInt(line[3]);
			if (x!=uno) {
				if (x<uno)
					cont+=(40-(uno-x))*9;
				else
					cont+=(x-uno)*9;
				x=uno;
			}
			if (x!=dos) {
				if (x<dos)
					cont+=(dos-x)*9;
				else
					cont+=(40-(x-dos))*9;
				x=dos;
			}
			if (x!=tres) {
				if (x<tres)
					cont+=(40-(tres-x))*9;
				else
					cont+=(x-tres)*9;
				x=tres;
			}
			sb.append(cont+"\n");
		}
		System.out.print(sb);
		br.close();
	}

}
