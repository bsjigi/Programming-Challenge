import java.util.Scanner;

class Main {

   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String list_index = sc.nextLine();
        String list_value = sc.nextLine();

        int n_string = 4;

        String[] string = new String[n_string];

        for(int i=0;i<n_string;i++){
            string[i] = sc.nextLine().toUpperCase();
        }

        for(int i=0;i<n_string;i++) {
            boolean flag = false;
            for (int j = 0; j < string[i].length(); j += 2) {
                if (string[i].replace(" ","").length()%2!=0){
                    flag = true;
                    break;
                }
                if(string[i].charAt(j) == ' '){
                    System.out.print(' ');
                    j++;
                }

                if(list_index.indexOf(string[i].charAt(j))!=-1 && list_index.indexOf(string[i].charAt(j+1))!=-1) {
                    System.out.print(list_value.charAt(list_index.indexOf(string[i].charAt(j)) * 6 + list_index.indexOf(string[i].charAt(j + 1))));
                }
                else{
                    flag = true;
                }

            }
            if (flag)
                System.out.print("-ERROR-");

            if (i!=n_string-1)
                System.out.println();
        }



    }

}
