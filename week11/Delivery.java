import java.util.*;

public class Main {

    static int n, m, k;
    static int adj[][];
    static boolean visited[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        adj = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt(), dest = sc.nextInt();
            adj[src][dest] = 1;
            adj[dest][src] = 1;
        }

        visited[k] = true;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(k);
        if (!dfs(k, path))
            System.out.println(0);
    }

    public static boolean dfs(int cur, List<Integer> path) {
        boolean hasFound = false;
        if (path.size() == n && adj[path.get(path.size() - 1)][k] == 1) {
            for (Integer node : path) System.out.print(node + " ");
            System.out.println(k);
            return true;
        }
        for (int next = 1; next <= n; next++) {
            if (!visited[next] && adj[cur][next] == 1) {
                visited[next] = true;
                path.add(next);
                hasFound |= dfs(next, path);
                visited[next] = false;
                path.remove(path.size() - 1);
            }
        }
        return hasFound;
    }
}