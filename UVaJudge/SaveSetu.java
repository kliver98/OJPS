/**
 * @author Kliver Daniel
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3834
 */
import java.util.Scanner;

public class SaveSetu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine().trim()), cont = 0;
		while (t-->0) {
			String[] l = sc.nextLine().split(" ");
			if (l.length>1)
				cont += Integer.parseInt(l[1]);
			else
				System.out.println(cont);
		}
		sc.close();
	}

}
