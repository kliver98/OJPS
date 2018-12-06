/**
 * @author Kliver Daniel
 */
import java.util.*;

class MonkInTheRealEstate {
    public static void main(String args[] ) throws Exception {
       
        StringBuilder sb = new StringBuilder();
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine().trim());
        while (T-->0) {
            int E = Integer.parseInt(s.nextLine().trim()), cont = 0;
            boolean nodes[] = new boolean[10000];
            for (int i = 0; i<E; i++) {
                int x = s.nextInt()-1,y = s.nextInt()-1;
                if (!nodes[x]) {
                    nodes[x] = true;
                    cont++;
                }
                if (!nodes[y]) {
                    nodes[y] = true;
                    cont++;
                }
            }
            sb.append(cont+"\n");
            if (T==0)
            	break;
            s.nextLine();
        }
        System.out.print(sb.toString());
        s.close();
    }
}
