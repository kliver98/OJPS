/**
 * @author Kliver Daniel
 */
import java.util.Scanner;

public class MonkAtTheGraphFactory {

	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());
        int cont = 0;
        for (int i = 0; i <n ; i++) {
          cont += s.nextInt();
        }
        int val = (n-2)*2+2;
        String rst = "No";
        if (cont==val)
        	rst =  "Yes";
      System.out.println(rst);
      s.close();
    }

}
