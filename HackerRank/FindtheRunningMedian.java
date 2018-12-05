/**
 * @author Kliver Daniel
 */
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindtheRunningMedian {

	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	
    static double[] runningMedian(int[] a) {
    	double[] salida = new double[a.length];
    	for (int i = 0; i < a.length; i++) {
			maxHeap.offer(a[i]);
			minHeap.offer(maxHeap.poll());
			if ( minHeap.size() > maxHeap.size() )
				maxHeap.offer(minHeap.poll());
			if ( minHeap.size() == maxHeap.size() )
				salida[i] = (maxHeap.peek()+minHeap.peek())/2.0;
			else
				salida[i] = maxHeap.peek();
		}
    	return salida;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }
    }

}
