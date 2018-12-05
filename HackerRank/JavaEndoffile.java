/**
 * @author Kliver Daniel
 */
import java.util.*;

public class JavaEndoffile {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String l = "";
    int cont = 1;
    while ( (l = sc.nextLine()) != null && !l.isEmpty() ) {
        System.out.println(cont+" "+l);
        cont++;
    }    
    sc.close();
    }
}