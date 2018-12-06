import java.util.Scanner;
/**
 * 
 * @author Kliver Daniel
 *
 */
public class AutomaticAnswer {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
			int nm = s.nextInt();
			nm = 15*nm+62;
			System.out.println((nm+"").charAt((nm+"").length()-2));
		}
		s.close();
	}

}
