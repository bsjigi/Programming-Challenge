import java.util.Scanner;

class Main {

    public static void main(String[] args){

        int n,m;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] buf = new int[m];
      	if(m <= 100){
        for(int i=0;i<m;i++){
            buf[i] = sc.nextInt();
        	}
				}
        int ultra_rare = 0;
        int super_rare =0;
        int rare =0;
        int normal = 0;
				if (n <= 10000){
        for(int i=1;i<=n;i++){
            int special_case = 0;
            int num = 0;

            for(int j=0;j<8;j++){
                if(i == Math.pow(2,j)){
                    special_case = 1;
                    ultra_rare++;
                    break;
                }
            }

            if(special_case==0){
                for(int j=0;j<buf.length;j++){
                    if (i % buf[j] == 0){
                        num++;
                    }
                }
            }
            else{
                continue;
            }

            if(num == 0) {
                normal++;
            }else if(num==1){
                rare++;
            }else if(num==2){
                super_rare++;
            }else{
                ultra_rare++;
            }
        }
			}

        System.out.print(ultra_rare +" ");
        System.out.print(super_rare +" ");
        System.out.print(rare +" ");
        System.out.print(normal +" ");
    }
}
