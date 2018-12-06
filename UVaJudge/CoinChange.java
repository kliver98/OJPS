import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 
 * @author Kliver Daniel
 *
 */
public class CoinChange {
	static int[] coins = {1,5,10,25,50};
    static long getWays(int n) {
        int[] combinations = new int[Integer.parseInt(n+"")+1];
        combinations[0] = 1;
        for ( int i : coins ) {
            for ( int j = 1; j < combinations.length; j++ ) {
                if ( j >= i ) {
                    combinations[j] += combinations[j-i];
                }
            }
        }
        return combinations[n];
    }
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = "";
    	while ( (line = br.readLine()) != null  ) {
    		int n = Integer.parseInt(line.trim());
    		System.out.println(getWays(n));
    	}
    	br.close();
    }
}
