/**
 * @author Kliver Daniel
 */
import java.io.*;
import java.util.*;

public class TheCoinChangeProblem {
	
    static long getWays(long n, long[] c) {
        long[] combinations = new long[Integer.parseInt(n+"")+1];
        combinations[0] = 1;
        for ( long i : c ) {
            for ( int j = 1; j < combinations.length; j++ ) {
                if ( j >= i ) {
                    combinations[j] += combinations[j-Integer.parseInt(i+"")];
                }
            }
        }
        return combinations[Integer.parseInt(n+"")];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        long ways = getWays(n, c);
        bufferedWriter.write(ways+"");
        bufferedWriter.close();

        scanner.close();
    }
}
