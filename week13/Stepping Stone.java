import java.util.Scanner;

class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();

        long[] table = new long[n + 1];
        boolean disable[] = new boolean[n + 1]; for (int i = 0; i < n + 1; i++) disable[i] = false;
        table[0]= 1;

        for(int i = 0; i < k; i++)
            disable[scan.nextInt()] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                if (i + j <= n) table[i + j] += disable[i] ? 0 : table[i];
        }

            System.out.println(table[n]);

    }
}