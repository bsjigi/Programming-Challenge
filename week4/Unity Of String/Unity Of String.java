import java.util.Scanner;

class Main {

    public static int get_num_redundant(String str){

        int count =0;

        for(char i = 'a';i<='z';i++){
            if(str.contains(i+""))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        sc.nextLine();

        String string = sc.nextLine();

        int best = num;
        int best_index = 0;

        for(int i=0;i<string.length()-num+1;i++){
            if(get_num_redundant(string.substring(i,i+num))<best){
                best = get_num_redundant(string.substring(i,i+num));
                best_index = i;
            }
        }

        System.out.print(best_index);
    }
}