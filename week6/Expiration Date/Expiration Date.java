


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

class Main {
	public static void main(String as[]) throws ParseException {
		Scanner sc = new Scanner(System.in);

		String str[];
		

		int i, n = sc.nextInt();
		str = new String[n];
		
		sc.nextLine();

		for (i = 0; i < n; i++) {

			str[i] = sc.nextLine();

		}

		Arrays.sort(str);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("19/10/2017");
		
		
		for (i = 0; i < str.length; i++) {
			Date date1 = sdf.parse(str[i].split(" ")[1]);
			if(date1.compareTo(date)>=0)
			System.out.println(str[i]);
		}

	}
}