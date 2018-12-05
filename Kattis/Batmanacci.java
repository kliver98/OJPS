/**
 * @author Kliver Daniel
 *
 */
import java.math.BigInteger;
import java.util.Scanner;
public class Batmanacci {
	
	static final BigInteger[] lg = new BigInteger[100000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		longitudes();
		String[] linea = sc.nextLine().split(" ");
		int n = Integer.parseInt(linea[0])-1;
		BigInteger k = new BigInteger(linea[1]);
		System.out.println(ver(n,k));
		sc.close();
	}
	
	public static void longitudes() {
		lg[0] = new BigInteger("1");
		lg[1] = new BigInteger("1");
		for (int i = 2; i < lg.length; i++)
			lg[i] = lg[i-2].add(lg[i-1]);
	}
	
	public static String ver(int n, BigInteger k) {
		if ( n==0 ) {
			return "N";
		} else if ( n==1 ) {
			return "A";
		}
		BigInteger v = lg[n-2]; 
		if ( v.compareTo(k)<0 )
			return ver(n-1,k.subtract(lg[n-2]));
		else
			return ver(n-2,k);
	}

}
