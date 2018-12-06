import java.util.Scanner;

public class PackingForHoliday {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), j = 1;
		while (t-->0) {
			String r = "good";
			for (int i = 0; i < 3; i++)
				r = sc.nextInt()>20 ? "bad":r;
			System.out.println("Case "+j+": "+r);
			j++;
		}
		sc.close();
	}

}
