
import java.util.Scanner;

class Main {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		String input = new String();

		while (scanner.hasNext()) {

			input = scanner.nextLine();

			r(input);

		}

	}

	static String r(String s) {

		int len = s.length();

		String first, last;
		String temp = s;

		for (int i = 0; i < (len - 1); i++) {

			first = s.substring(0, 1);
			last = s.substring(1);
			s = last + first;

			if (temp.compareTo(s) > 0) {
				temp = s;
			}

		}

		System.out.println(temp);
		return s;

	}

}