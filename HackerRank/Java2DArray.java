/**
 * @author Kliver Daniel
 */
import java.util.*;

public class Java2DArray {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        System.out.println(maxSum(arr));
        scanner.close();
    }
    
    public static int maxSum(int[][] arr) {
    	int mayor = -64;
    	int actual = 0;
    	int n1 = 0;
    	while ( n1<4 ) {
    		int n2 = 0;
    		while (n2<4) {
        		for (int i = 0+n1; i < 3+n1; i++) {
        			for (int j = 0+n2; j < 3+n2; j++) {
        				if (  i!=(n1+1) || ( j==(n2+1) && j!=(n2+2) ) )
        					actual += arr[i][j];
        			}
        		}
            	mayor = Math.max(actual, mayor);
            	actual = 0;
            	n2++;
    		}
        	n1++;
    	}
    	return mayor;
    }
    
}