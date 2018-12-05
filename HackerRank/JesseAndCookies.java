/**
 * @author Kliver Daniel
 */
import java.io.*;
import java.util.*;

public class JesseAndCookies {
	
    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for ( int i = 0; i < A.length; i++ ) {
            q.offer(A[i]);
        }
        int l = 0;
        while ( !(q.peek() >= k) && q.size() > 1 ) {
            int a = q.poll(), b = q.poll();
            int c = a+(2*b);
            q.offer(c);
            l++;
        }
        if ( q.peek() < k )
            l = -1;
        return l;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
