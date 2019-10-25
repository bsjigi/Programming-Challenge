import java.util.Scanner;

 class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int count =0;
        int threshold = 1;

        String result = "";

        result = result.concat(str.charAt(0)+"");
        for(int i=0;i<str.length();i++) {
            count ++;

            if(count == threshold){
                count =0 ;
                threshold ++;
                result = result.concat(str.charAt(i+1)+"");
            }
        }

        int word_count=1;
        int ascii_count=0;
        int unicode_count=0;

        for(int i=0;i<result.length();i++){
            if (result.charAt(i) == ' '){
                word_count++;
            }
            else if ((int)result.charAt(i)>=0 && (int)result.charAt(i)<=127){
                ascii_count++;
            }
            else{
                unicode_count ++;
            }
        }

        System.out.print(word_count+" ");
        System.out.print(ascii_count+" ");
        System.out.print(unicode_count);

    }
}

