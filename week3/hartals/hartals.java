import java.util.Scanner;

class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int num_test_case = 0;
        num_test_case = sc.nextInt();
        boolean[][] date_lost = new boolean[num_test_case][];
        int[] lost_day = new int [num_test_case];
        int[] num_test_day = new int[2];

        for(int k=0;k<num_test_case;k++) {


            int num_of_p =0;

            num_test_day[k] = sc.nextInt();
            num_of_p = sc.nextInt();

            int[] score = new int[num_of_p];
            int[] date_score = new int[num_test_day[k]];
            date_lost[k] = new boolean[num_test_day[k]];


            for (int i = 0; i < num_of_p; i++) {
                score[i] = sc.nextInt();
            }

            for (int i = 1; i <= num_test_day[k]; i++) {
                date_score[i - 1] = 0;
                for (int j = 0; j < score.length; j++) {

                    if (i % score[j] == 0) {
                        date_score[i - 1]++;
                    }
                }
            }
            lost_day[k] =0;
            for (int i = 0; i < num_test_day[k]; i++) {
                if (date_score[i] >= (float) num_of_p / 2.0 && i % 7 != 3 && i % 7 != 6 && i % 7 != 0) {
                    date_lost[k][i] = true;
                    lost_day[k]++;
                }
            }

        }
        int flag= 0;
        for(int k=0;k<num_test_case;k++) {
            String[] Date = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
            System.out.println("Lost: " + lost_day[k]);
            for (int i = 0; i < num_test_day[k]; i++) {
                if (date_lost[k][i])
                    System.out.println(Date[i % 7] + ": " + (i + 1));
            }
            if(flag==0)
                System.out.println();
            flag++;
        }
    }
}
