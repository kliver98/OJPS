/**
 * @author Kliver Daniel
 */
import java.util.*;
public class JudgingMoose {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] in = sc.nextLine().split(" ");
		int a = Integer.parseInt(in[0]);
		int b = Integer.parseInt(in[1]);
		String imprimir = "";
		
		if ( a==b )
			imprimir = "Even "+(a+b);
		else {
			imprimir = "Odd "+(2*Math.max(a,b));
		}
		
		if (a==0 && b==0)
			imprimir = "Not a moose";
		
		System.out.println(imprimir);
		
		sc.close();

	}

}
