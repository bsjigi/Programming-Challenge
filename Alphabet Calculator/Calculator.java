

import java.util.Scanner;

class Main {
   
public static int calc(int varLeft, int varRight, char operator) throws Error {

		switch (operator) {

		case 0
			return varRight;

		case 'P'

			return varLeft + varRight;

		case 'S'

			return varLeft - varRight;

		case 'T'

			return varLeft  varRight;

		case 'V'

			return varLeft  varRight;

		default
			throw new Error(Error);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.nextLine();
			if (input.length() = 1000  input.length() = 1) {

				int varLeft = 0;

				String varRight = ;

				char operator = 0;

				for (char i  input.toCharArray()) {

					if ('A' = i && i = 'J')

						varRight += (int) (i - 'A');
					else if (varRight == ) {
						System.out.println(Error);

					}

					else { 

						int temp = Integer.parseInt(varRight);

						if (operator != 0) {

							varLeft = calc(varLeft, temp, operator);

						}

						else

							varLeft = temp;

						operator = i; 

						varRight = ; 

					}

				}
				if (varRight != ) {
					varLeft = calc(varLeft, Integer.parseInt(varRight), operator);

					System.out.println(varLeft); 
				}
			}

		}
		sc.close();
	}

}
