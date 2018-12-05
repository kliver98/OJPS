/**
 * @author Kliver Daniel
 */
import java.util.*;

public class JavaIfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String ans = "";
        if (n%2 == 0 && (n>20 || n < 6))
        	ans += "Not ";
        ans += "Weird";
        System.out.println(ans);
        scanner.close();
    }
}
