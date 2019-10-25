import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String org = sc.nextLine();
        String conv = sc.nextLine();

        String alphabet =      "abcdefghijklmnopqrstuvwxyz";
        char[] conv_alphabet = "00000000000000000000000000".toCharArray();

        String [] org_arr = org.split(" ");
        String [] conv_arr = conv.split( " ");

        boolean [] redundant = new boolean[org_arr.length];

        for(int i=0;i<org_arr.length;i++){
            redundant[i] = false;
            for(int j=0;j<org_arr.length;j++){
                if(i!=j && org_arr[i].length() == org_arr[j].length()){
                    redundant[i] = true;
                    break;
                }
            }
        }

        int count =0;

        for(int i=0;i<org_arr.length;i++){
            for(int j=0;j<conv_arr.length;j++){
                if (!redundant[i] && org_arr[i] != null && conv_arr[j] != null){
                    if(org_arr[i].length() == conv_arr[j].length()){
                        for(int k=0;k<org_arr[i].length();k++){
                            conv_alphabet[alphabet.indexOf(org_arr[i].charAt(k))] = conv_arr[j].charAt(k);
                        }
                        count++;
                        org_arr[i] = null;
                        conv_arr[j] = null;
                    }
                }
            }
        }

        for(int i=0;i<org_arr.length;i++){
            if(org_arr[i] != null && redundant[i]){
                for(int j=0;j<org_arr[i].length();j++){
                    int cnt =0;
                    char replace_ = ' ';
                    for(int k=0;k<org_arr[i].length();k++){
                        if(j!=k && org_arr[i].charAt(j) == org_arr[i].charAt(k)) {
                            replace_ = org_arr[i].charAt(j);
                            cnt++;
                        }
                    }

                    if(cnt>=1){
                        org_arr[i]= org_arr[i].replaceFirst(replace_+"","");
                    }
                }
            }

            if(conv_arr[i] != null){
                for(int j=0;j<conv_arr[i].length();j++){
                    int cnt =0;
                    char replace_ = ' ';
                    for(int k=0;k<conv_arr[i].length();k++){
                        if(j!=k && conv_arr[i].charAt(j) == conv_arr[i].charAt(k)) {
                            replace_ = conv_arr[i].charAt(j);
                            cnt++;
                        }
                    }

                    if(cnt>=1){
                        conv_arr[i]= conv_arr[i].replaceFirst(replace_+"","");
                    }
                }
            }
        }


        for(int i=0;i<org_arr.length;i++){
            for(int j=0;j<conv_arr.length;j++){
                if (redundant[i] && org_arr[i] != null && conv_arr[j] != null){
                    if(org_arr[i].length() == conv_arr[j].length()){
                        for(int k=0;k<org_arr[i].length();k++){
                            conv_alphabet[alphabet.indexOf(org_arr[i].charAt(k))] = conv_arr[j].charAt(k);
                        }
                        count++;
                        org_arr[i] = null;
                        conv_arr[j] = null;
                    }
                }
            }
        }

        String testString ="the quick brown fox jumps over the lazy dog";

        for(int i=0;i<testString.length();i++){
            if(testString.charAt(i)==' ')
                System.out.print(' ');
            else{
                System.out.print(conv_alphabet[alphabet.indexOf(testString.charAt(i))]);
            }
        }

        System.out.println();

        for(int i=0;i<alphabet.length();i++){
            if (i==alphabet.length()-1){
                System.out.print(alphabet.charAt(i)+" "+conv_alphabet[i]);
            }
            else{
                System.out.println(alphabet.charAt(i)+" "+conv_alphabet[i]);
            }


        }

    }
}