/**
 * @author Kliver Daniel
 */
import java.util.*;
import java.io.*;
public class Collatz {

    static Map<Long, Long> mapa; //creo el mapa

    public static void main(String args[]) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] linea = sc.readLine().split(" ");
            long A = Integer.parseInt(linea[0]);
            long B = Integer.parseInt(linea[1]);
            if (A == 0 && B == 0)
                break;
            mapa = new HashMap<>();
            generar(A); //Se genera todo
            int cB = -1; //Los pasos necesarios de B
            @SuppressWarnings("unused")
			int num = 0;
            long b = B;
            while (true) {
                ++cB;
                if (mapa.containsKey(b))
                    break;
                if (b == 1) {
                    num = 1;
                    break;
                }
                if (b % 2 == 0) {
                    b = b / 2;
                } else {
                    b = b * 3 + 1;
                }

            }
            bw.write(A + " needs " + mapa.get(b) + " steps, " + B + " needs " + cB + " steps, they meet at " + b+"\n");

        }
        bw.close();

    }

    static void generar(long x) {
        long i = x;
        long cont = 0; //Los pasos dados
        mapa.put(i, cont++);
        while (i != 1) { //hasta que llegue a uno
        	
            if (i % 2 == 0)
                i = i / 2;
            else
                i = i * 3 + 1;
            
            if (!mapa.containsKey(i)) //Si no generaria error, se duplica la llave
                mapa.put(i, cont);
            cont++;
        }
    }
}