import java.util.Scanner;

public class OneTwoThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = Integer.parseInt(sc.nextLine());
		while (c-->0) {
			char[] cs = sc.nextLine().toCharArray();
			if (cs.length==3) {
				if ((cs[0]=='o' && cs[1]=='n')||(cs[0]=='o' && cs[2]=='e')||(cs[1]=='n' && cs[2]=='e'))
					System.out.println("1");
				else
					System.out.println("2");
			} else
				System.out.println("3");
		}
		sc.close();
	}

}
