/**
 * @author Kliver Daniel
 */
import java.util.*;

public class QHEAP1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine().trim());
        PriorityQueue<Integer> a = new PriorityQueue<Integer>();
        StringBuilder str = new StringBuilder();
        while ( q-- > 0 ) {
            String[] line = sc.nextLine().split(" ");
            int act = Integer.parseInt(line[0]);
            int val = 0;
            if ( act != 3 )
                val = Integer.parseInt(line[1]);
            if ( act == 1 )
                a.offer(val);
            else if ( act == 2 )
                a.remove(val);
            else
                str.append(a.peek()+"\n");
        }
        System.out.print(str.toString());
        sc.close();
    }
}