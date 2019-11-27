

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Main {

    private static class Edge{
        public int t, d, w;

        Edge(int t, int d, int w){
            this.t = t;
            this.d = d;
            this.w = w;
        }
    }

    public static class Comp implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o2.w - o1.w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] parent = new int[n];
        ArrayList<Edge> eList = new ArrayList<>();
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int w = scanner.nextInt();
                if (w != 0) eList.add(new Edge(i, j, w));
            }


        Collections.sort(eList, new Comp());

        int res = eList.get(0).w;
        union(parent, eList.get(0).t, eList.get(0).d);

        for (int i = 1; i < eList.size(); i++){
            Edge cur = eList.get(i);
            if (union(parent, cur.t, cur.d)){
                res += cur.w;
            }
        }

        System.out.println(res);
    }

    public static int find(int[] par, int n){
        return par[n] == n ? n : (par[n] = find(par, par[n]));
    }

    public static boolean union(int[] par, int a, int b){
        int parA = find(par, a);
        int parB = find(par, b);

        if (parA == parB) return false;

        par[parB] = parA;
        return true;
    }
}
