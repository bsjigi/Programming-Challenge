

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public Main(){
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		
		ArrayList<String> al = new ArrayList<String>();
		al.add(" ");
				
		for(int i=0; i<num.length; i++){
			al.addAll(new ArrayList<String>(al));
			for(int j=1<<i; j<1<<(i+1); j++ )
				al.set(j, al.get(j)+num[i]+" ");
		}
		Collections.sort(al);
		for(int j=0; j<num.length*2+1; j++)
			for(int i = 0; i<al.size(); i++)
				if(al.get(i).length()==j+1)
					System.out.println("{"+al.get(i)+"}");
	}
	public static void main(String[] args){
		new Main();
	}

}
