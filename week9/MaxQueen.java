

import java.util.*;

class Main {

    public static void main(String[] args) {
        int next = new Scanner(System.in).nextInt();
        loopNext(next);
        for(int i = 0;i < next;i++)
            System.out.print(0);
    }

    public static void loopNext(int maxQueen) {
        int[] a = new int[maxQueen];
        loopNext(a, 0);
    }

    public static void loopNext(int[] q, int depth) {
        int maxQueen = q.length;
        if (depth == maxQueen) {
            for(int i : q)
                System.out.print(i + 1);
            System.out.println();
            System.exit(0);
        } else {
            for (int i = 0; i < maxQueen; i++) {
                q[depth] = i;
                if (isNative(q, depth))
                    loopNext(q, depth + 1);
            }
        }
    }

    public static boolean isNative(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])
                return false;
            if ((q[i] - q[n]) == (n - i))
                return false;
            if ((q[n] - q[i]) == (n - i))
                return false;
        }
        return true;
    }


}
