/**
 * @author Kliver Daniel
 */
import java.io.*;

public class ADifferentProblem {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String nn = br.readLine();
		
		while (nn!=null) {
			
			long a = Long.parseLong(nn.split(" ")[0]);
			long b = Long.parseLong(nn.split(" ")[1]);
			
			long c = a-b;
			
			c = Math.abs(c);
			
			wr.write(c+"\n");
			
			nn = br.readLine();
			
		}
		
		wr.close();
		br.close();
		
	}
	
}
