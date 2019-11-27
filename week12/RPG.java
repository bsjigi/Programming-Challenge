

import java.util.Scanner;

 class Main {

    private final static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[][] floyd = new int[n][n];

        for (int i = 0; i < n; ++i) {
            scan.next();
            for (int j = 0; j < n; j++) {
                floyd[i][j] = scan.nextInt();

                if (floyd[i][j] == 0) floyd[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    floyd[j][k] = Math.min(floyd[j][i] + floyd[i][k], floyd[j][k]);

        int itemCount = scan.nextInt();
        int sum = 0, last = 0;
        for (int i = 0; i < itemCount; i++){
            int cur = scan.nextInt();
            sum += floyd[last][cur];
            last = cur;
        }
			if(itemCount == 1 && last == 0){
				sum = 0;
			}

        System.out.println(sum);
    }
}
