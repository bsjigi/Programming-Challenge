

import java.util.Arrays;
import java.util.Scanner;

 class Main {
	
	public static void splitMine(int N, int[][] mine, boolean[][] map, int i, int j, int sec) {
		
		if (i < 0 || (N-1) < i) {
			return;
		}
		if (j < 0 || (N-1) < j) {
			return;
		}
		if (map[i][j]) return;
		
		if (mine[i][j] == 0) return; 
		
		map[i][j] = true;
		mine[i][j] = sec;
		
		splitMine(N, mine, map, i+1, j, sec);
		splitMine(N, mine, map, i-1, j, sec);
		splitMine(N, mine, map, i, j+1, sec);
		splitMine(N, mine, map, i, j-1, sec);
		
	}

	public static void printMine(int N, int[][] mine) {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mine[i][j] +  " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N;
		
		N = sc.nextInt();
		
		int[][] mine = new int[N][N];
		boolean[][] map = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				mine[i][j] = sc.nextInt();
				map[i][j] = false;
			}
		}

		
		boolean firstMine = true;
		int secNum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (firstMine) {
					if (mine[i][j] == 1) {
						firstMine = false;
						secNum++;
						splitMine(N, mine, map, i, j, secNum);
					}
				}
				else {
					if (mine[i][j] == 1) {
						splitMine(N, mine, map, i, j, secNum);
					}
					else {
						firstMine = true;
					}
				}
			}
		}
		

		
		
		printMine(N, mine);
		
	}
	
}
