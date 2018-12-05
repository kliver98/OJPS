/**
 * @author Kliver Daniel
 */
import java.util.Scanner;
public class Server {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] linea1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(linea1[0]);
        int t = Integer.parseInt(linea1[1]);
        
        int cont = 0;
        boolean salir = false;
        int sumatoria = 0;
        for (int i = 0; i < n && !salir; i++) {
            sumatoria += sc.nextInt();
            if ( sumatoria >t )
                salir = true;
            else
                cont++;
        }
        
        System.out.println(cont);
        
        sc.close();
    }

}