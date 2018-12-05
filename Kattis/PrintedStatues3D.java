/**
 * @author Kliver Daniel
 */
import java.util.Scanner;

public class PrintedStatues3D {

    public static void main(String[] args) {
        
        int[] days = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = 1;

        for (int i = 0; i < days.length; i++) {
            if ( days[i]<n )
                k++;
            else
                break;
        }
        
        System.out.println(k);
        
        sc.close();

    }

}