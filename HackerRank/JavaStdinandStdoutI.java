/**
 * @author Kliver Daniel
 */
import java.util.*;

public class JavaStdinandStdoutI {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
        	int a=sc.nextInt();
        	System.out.println(a);
        }
        sc.close();
    }
}