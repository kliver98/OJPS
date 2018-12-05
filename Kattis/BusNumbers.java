/**
 * @author Kliver Daniel
 */
import java.util.Arrays;
import java.util.Scanner;

public class BusNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = sc.nextInt();
        Arrays.sort(list); //ordeno

        StringBuilder sb = new StringBuilder();
        if ( n <= 2 ) {
        	for (int i = 0; i < list.length; i++) {
				sb.append(list[i]);
				if ( i < list.length-1 )
					sb.append(" ");
			}
        } else {
        	int range = 0;
        	for (int i = 0; i < list.length-1; i++) {
        		int nm = list[i];
        		int nm2 = list[i+1];
        		boolean entro = false;
        		if ( nm!=(nm2-1) ) {
        			if ( range >= 2 ) {
        				sb.append(list[i-range]+"-"+list[i]);
        				range = 0;
        				if ( i == (list.length-2) ) {
        					sb.append(" "+nm2);
        					entro = true;
        				}
        			} else {
        				if ( range > 0 ) {
        					sb.append(list[i-range]+" ");
        					range = 0;
        				}
        				sb.append(nm);
        				if ( i == (list.length-2) ) {
        					sb.append(" "+nm2);
        					entro = true;
        				}
        			}
        		} else {
        			range+=1;
        			if ( i == (list.length-2) && range >= 2 ) {
        				sb.append(list[i-range+1]+"-"+nm2);
        			} else if ( i == (list.length-2) ) {
        				sb.append(list[i-range+1]+" "+nm2);
        			}
        			entro = true;
        		}
        		if ( i < list.length-1 && !entro ) {
        			sb.append(" ");
        		}
        	}
        }
        System.out.println(sb.toString());
        sc.close();
    }
}