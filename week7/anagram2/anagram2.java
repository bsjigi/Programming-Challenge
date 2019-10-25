

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String next;
        while ((next = sn.next()) != null) {
            if (next.equals("*")) {
                System.exit(0);
            }
            String[] splits = next.split(":");
            List<String> anagrams = new ArrayList<>();
            process(anagrams, splits[0].toCharArray(), 0);
            anagrams = anagrams.stream().distinct().collect(Collectors.toList());
            anagrams.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println(anagrams.get(Integer.parseInt(splits[1])-1));
        }
    }

    static void process(List<String> anagrams, char[] a, int i) {
        if (i == a.length - 1)
            anagrams.add(new String(a));
        else {
            for (int x = i; x < a.length; x++) {
                //swap a[i] with a[j]
                char c = a[i];
                a[i] = a[x];
                a[x] = c;
                process(anagrams, a, i + 1);
                c = a[i];
                a[i] = a[x];
                a[x] = c;
            }
        }
    }


}
