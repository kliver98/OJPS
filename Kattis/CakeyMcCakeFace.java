/**
 * @author Kliver Daniel
 */
import java.util.*;

public class CakeyMcCakeFace {

    public static void main(String[] args) {
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] n_ = new int[n], m_ = new int[m];
        for (int i = 0; i < n; i++)
            n_[i] = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++)
            m_[i] = sc.nextInt();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k, v = 1;
                if ( (k = m_[i]-n_[j]) >= 0 ) {
                    if ( map.get(k) != null )
                        v += map.get(k);
                    map.put(k,v);
                }
            }
        }
        
        Set<Integer> s = map.keySet();
        int h = Integer.MIN_VALUE, k_min = 0;
        for (int i : s) {
            int b = map.get(i);
            if ( h < b  ) {
                k_min = i;
                h = b;          
            } else if ( h==b ) {
                k_min = Math.min(k_min, i);
            }
        }
        sc.close();
        System.out.println(k_min);
    }

}