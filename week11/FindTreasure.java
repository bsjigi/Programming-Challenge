import java.util.*;

class Pos {
    public int i;
    public int j;

    Pos() {
    }

    Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n], dist = new int[n][n];
        final int[] di = {-1, 0, 1, 0}, dj = {0, -1, 0, 1};
        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                dist[i][j] = -1;
            }

        dist[0][0] = 1;
        q.offer(new Pos(0, 0));

        while (q.size() > 0) {
            Pos cur = q.poll();
            if (cur.i == n - 1 && cur.j == n - 1) break;

            for (int k = 0; k < 4; k++) {
                int ni = cur.i + di[k], nj = cur.j + dj[k];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n
                        && map[ni][nj] == 1 && dist[ni][nj] == -1) {
                    q.offer(new Pos(ni, nj));
                    dist[ni][nj] = dist[cur.i][cur.j] + 1;
                }
            }
        }

        System.out.println(dist[n - 1][n - 1]);
    }
}