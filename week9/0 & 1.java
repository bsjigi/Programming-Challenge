

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainLoop:
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            if (next.length() > 10) {
                System.out.println("Length of text [" + next + "] is bigger than 10.");
                continue;
            }

            if (next.length() < 3) {
                System.out.println("Length of text [" + next + "] is smaller than 3.");
                continue;
            }

            for (char c : next.toCharArray())
                if (!isNumber(c)) {
                    System.out.println("Text [" + next + "] contains non-binary character.");
                    continue mainLoop;
                }

            int[] ar = new int[next.length()];
            for (int i = 0; i < next.length(); i++) {
                ar[i] = (int) next.charAt(i) - '0';
//                        System.out.println((int)next.charAt(i) - '0');
            }
            PossiblePatterns pp = new PossiblePatterns(ar);
            switch (pp.getPossibleList().size()) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    StringBuilder sb = new StringBuilder();
                    for (Integer i : pp.getPossibleList().get(0))
                        sb.append(i);
                    System.out.println(sb.toString());
                    break;
                default:
                    System.out.println("multiple");
            }
        }
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isBinary(char c) {
        return c >= '0' && c <= '1';
    }


    public static List<Integer[]> getBeforeStatus(Integer[] array) {
        RoundArray<Integer> ra = new RoundArray<>(array);
        // If all content is matched, no before status will exists.
        boolean isStableArray = true;
        for (int i = 0; i < array.length; i++)
            if (isNumberUnstable(ra, i)) {
                System.out.println("** Number unstable!");
                System.out.println("** " + ra.get(i - 1) + "/" + ra.get(i) + "/" + ra.get(i + 1));
                isStableArray = false;
                break;
            }
        if (isStableArray) {
            System.out.println("Array stabilized; Cannot parse next array");
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    public static boolean isNumberUnstable(RoundArray<Integer> arr, int current) {
        return !arr.get(current - 1).equals(arr.get(current + 1));
    }

    public static Integer[] createNextArray(Integer[] arr) {
        RoundArray<Integer> ra = new RoundArray<>(arr);
        Integer[] ar = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            if (isNumberUnstable(ra, i))
                ar[i] = Math.abs(arr[i] - 1);
            else
                ar[i] = arr[i];
        return ar;
    }

    public static <T> boolean isMatch(T[] l1, T[] l2) {
        if (l1.length != l2.length)
            return false;
        for (int i = 0; i < l1.length; i++)
            if (!l1[i].equals(l2[i]))
                return false;
        return true;
    }

    static class PossiblePatterns {
        private static Integer[] ZERO_ARRAY = new Integer[0];

        private List<List<Integer>> lst = new ArrayList<>();
        private Integer[] original;

        public PossiblePatterns(int[] currentArrays) {
            this.original = new Integer[currentArrays.length];
            for (int i = 0; i < currentArrays.length; i++)
                original[i] = currentArrays[i];
            for (int i = 0; i < currentArrays.length; i++) {
                lst.add(new ArrayList<>(
                        Arrays.asList(0, 1)
                ));
            }
            fetch();
        }

        public void fetch() {
            List<List<Integer>> possible = new ArrayList<>();
            List<Integer> firstList = lst.get(0);
            for (int i = 0; i < firstList.size(); i++) {
                List<Integer> pattern = new ArrayList<>();
                pattern.add(firstList.get(i));
                buildNext(possible, pattern, 1);
            }
            possible.removeIf(list -> {
                Integer[] nextArr = createNextArray(list.toArray(ZERO_ARRAY));
                return !isMatch(original, nextArr);
            });
            lst = possible;
        }

        private void buildNext(List<List<Integer>> possiblePattern, List<Integer> current, int depth) {
            if (depth >= lst.size()) {
                possiblePattern.add(new ArrayList<>(current));
                return;
            }
            List<Integer> l2 = lst.get(depth);
            for (int i = 0; i < l2.size(); i++) {
                current.add(l2.get(i));
                buildNext(possiblePattern, current, depth + 1);
                while (current.size() > depth) {
                    current.remove(depth);
                }
            }
        }

        public List<List<Integer>> getPossibleList() {
            return lst;
        }
    }

    static class RoundArray<T> {
        private T[] array;

        public RoundArray(T[] arr) {
            this.array = arr;
        }

        public T get(int str) {
            if (str <= 0) {
                while (str <= 0) {
                    str += array.length;
                }
            }

            if (str >= array.length) {
                str -= array.length;
            }
            return array[str];
        }

        public int length() {
            return array.length;
        }
    }
}
