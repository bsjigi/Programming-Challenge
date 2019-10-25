

import java.util.*;

 class Main {
  
    private char[] index = "abcdefghijklmnop".toCharArray();

    public Main(String str) {
      
        index = str.toCharArray();
    }


   
    public int getIndex(char c) {
        
        for (int i = 0; i < index.length; i++)
            
            if (index[i] == c)
             
                return i;
      
        return -1;
    }

  
    public String parse(String str) {
       
        List<Character> character = new ArrayList<>();
        for (char c : str.toCharArray()) {
            character.add(c);
        }
       
        character.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                
                return Integer.compare(getIndex(o1), getIndex(o2));
            }
        });
       
        char[] sorted = new char[character.size()];
     
        for (int i = 0; i < character.size(); i++)
            sorted[i] = character.get(i);
        
        return new String(sorted);
    }

   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main q = new Main(scan.nextLine());
        int nextParse = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < nextParse; i++)
            System.out.println(q.parse(scan.nextLine()));
    }
}
