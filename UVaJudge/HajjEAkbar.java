import java.util.Scanner;

public class HajjEAkbar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = "";
		int i = 1;
		while (!(l = sc.nextLine()).equals("*")) {
			String str = "Hajj-e-"+(l.equals("Hajj") ? "Akbar":"Asghar");
			System.out.println("Case "+i+": "+str);
			i++;
		}
		sc.close();
	}

}
