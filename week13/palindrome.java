import java.util.Scanner; 
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int answer = 0;
		String s = input.next();
		String pel = "";
		
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				String subString = s.substring(i, j);
				String reverse = new StringBuffer(subString).reverse().toString();
				if(subString.equals(reverse) && subString.length() > answer) {
					answer = subString.length();
					pel = subString;
				}
				else if(answer == 1){
					pel = "null";
				}
				
			}
		}
		System.out.println(pel);
	}
}