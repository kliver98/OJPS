import java.util.Scanner;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2843
 * @author Kliver Daniel
 *
 */
public class CreditCheck {
	
	static int calculate(String[] numbers) {
		int uno = 0,dos = 0, value = 0;
		for (int i = 0; i < numbers.length; i++) {			
			for (int j = 1; j < 4; j+=2) {
				value = Integer.parseInt(numbers[i].split("")[j-1])*2;
				if ( value < 10 )
					uno += value;
				else {
					String[] nm = (value+"").split("");
					for (int k = 0; k < nm.length; k++) {
						uno += Integer.parseInt(nm[k]);
					}
				}
				value = Integer.parseInt(numbers[i].split("")[j]);
				dos += value;
			}
		}
		return uno+dos;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine().trim());
		StringBuilder sb = new StringBuilder();
		while ( N-- > 0 ) {
			String[] line = sc.nextLine().split(" ");
			int value = calculate(line) % 10;
			String str = value==0 ? "Valid":"Invalid";
			sb.append(str+"\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}

}
