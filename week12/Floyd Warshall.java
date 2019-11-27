

import java.util.Scanner;

 class Main {

    private final static int INF = (int) 1e9;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tcc = scanner.nextInt();

        for (int tc = 0; tc < tcc; tc++) {
            int n = scanner.nextInt(), e = scanner.nextInt();

            int[][] floyd = new int[n][n];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; j++)
                    floyd[i][j] = INF;

            for (int i = 0; i < e; i++){
                int v1 = scanner.nextInt(), v2 = scanner.nextInt(), w = scanner.nextInt();

                floyd[v1-1][v2-1] = w;
                floyd[v2-1][v1-1] = w;
            }

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++)
                        floyd[j][k] = Math.min(floyd[j][i] + floyd[i][k], floyd[j][k]);

            int s = scanner.nextInt();
            int a = scanner.nextInt();
            int d = scanner.nextInt();

                      int result = floyd[s-1][a-1] + floyd[a-1][d-1];
            System.out.println( result >= INF ? -1 : result);
        }

    }
}
