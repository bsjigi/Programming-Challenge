import java.util.Arrays;
import java.util.Scanner;

class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] buf = new String[200];
        int j=0;
        for(int i=0;i<6;i++){
            String temp = sc.next();

            if(temp.equals("*")) {
                Arrays.sort(buf,0,j);
                buf[j] = null;
                j--;
            }else{
                buf[j] = temp;
                j++;
            }
        }

        Arrays.sort(buf,0,j);
        for(int i=j-1;i>=0;i--){
            System.out.println(buf[i]);
        }
    }
}






