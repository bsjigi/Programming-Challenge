import java.util.*;

class Main {
    private static List<StringInfo> strs = new ArrayList<>();

    static class StringInfo implements Comparable<StringInfo> {
        private int amount;
        private String str;

        public StringInfo(String str) {
            this.amount = str.length() - str.replace("1", "").length();
            this.str = str;
        }

        @Override
        public int compareTo(StringInfo o) {
            return Integer.compare(o.amount, amount);
        }
    }

    static void printTheArray(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }
        strs.add(new StringInfo(sb.toString()));
//        System.out.println();
    }

    static void generateAllBinaryStrings(int n, int[] arr, int i, int c, int min, int max) {
        if (i == n) {
            if (c < min || c > max) {
            } else {
                printTheArray(arr, n);
            }
            return;
        }
        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1, c + 1, min, max);

        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1, c, min, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        int min = sc.nextInt();
        int max = sc.nextInt();

        int[] arr = new int[n];

        generateAllBinaryStrings(n, arr, 0, c, min, max);
        strs.sort(null);
        for(StringInfo xl : strs)
            System.out.println(xl.str);
    }
}