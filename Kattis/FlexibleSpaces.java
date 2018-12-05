/**
 * @author Kliver Daniel
 */
import java.util.BitSet;
import java.util.Scanner;

public class FlexibleSpaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] valores = sc.nextLine().split(" ");
		int w = Integer.parseInt(valores[0]);
		StringBuilder sb = new StringBuilder();
		
        int[] list = new int[Integer.parseInt(valores[1])+2];
        list[0] = 0;
        for (int i = 1; i < list.length-1; i++)
            list[i] = sc.nextInt();
        list[list.length-1] = w;
        
        BitSet bs = new BitSet(w);
        for (int i = 0; i < list.length-1; i++) {
			for (int j = i+1; j < list.length; j++)
				bs.set(list[j]-list[i]);
		}
        
        for (int i = 0; i < bs.size(); i++) {
			if ( bs.get(i) )
				sb.append(i+" ");
		}
		
        System.out.println(sb.toString());
        
		sc.close();
	}

}