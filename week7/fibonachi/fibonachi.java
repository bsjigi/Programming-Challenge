

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

 class Main {
	public static void main(String[] args) {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			while ((str = bi.readLine()) != null) {
				String[] split = str.split(" ");

				getPossibleCombination(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getPossibleCombination(int max, int combination) {
		int arr[] = new int[1000];
		if(combination >=1000){
			combination = 1000;
		}
		for (int i = 0; i < combination; i++) {
			for (int j = 0; j < i; j++) {
				arr[i] += arr[i - (j + 1)];
			}
			arr[i] = arr[i] + 1;
		}

		for (int i = combination; i < max; i++) {
			for (int j = 0; j < combination; j++) {
				arr[i] += arr[i - (j + 1)];
			}
		}
		
			System.out.println(arr[max-1]);
		
		return combination;

	}

}
