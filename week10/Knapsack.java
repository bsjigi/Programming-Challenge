

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

 class Main {
	
	static class Item {
		
		public int weight;
		public int value;
		public int index;
		
		public Item(int w, int v, int i) {
			this.weight = w;
			this.value = v;
			this.index = i;
		}
		
	}
	
	public static ArrayList<Integer> itemsIndex = new ArrayList<Integer>();
	
	private static int knap(int n, int w, ArrayList<Item> i) {
        
		if (n <= 0 || w <= 0) {
        	return 0;
        }
		
        if (i.get(n - 1).weight > w) {                  
            return knap(n - 1, w, i);
        } 
        else {
            return Math.max(knap(n - 1, w, i), knap(n - 1, w - i.get(n - 1).weight, i) + i.get(n - 1).value);
        }
        
	}
	
	private static Item knapItem(int n, int w, ArrayList<Item> i) {
        
		if (n <= 0 || w <= 0) {
        	return null;
        }
		
        if (i.get(n - 1).weight > w) {                  
            return knapItem(n - 1, w, i);
        } 
        else {
            if (knap(n - 1, w, i) < knap(n - 1, w - i.get(n - 1).weight, i) + i.get(n - 1).value) {
            	itemsIndex.add(i.get(n-1).index);
            	return knapItem(n - 1, w - i.get(n - 1).weight, i);
            }
            else {
            	return knapItem(n - 1, w, i);
            }
        }
        
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int maxWeight;
		int N;
		
		maxWeight = sc.nextInt();
		N = sc.nextInt();
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		for (int i = 0; i < N; i++) {
			
			int w = sc.nextInt();
			int v = sc.nextInt();
			
			items.add(new Item(w, v, i+1));
		
		}
		
		System.out.println(knap(N, maxWeight, items));
		knapItem(N, maxWeight, items);
		
		Collections.sort(itemsIndex);
		System.out.print("{ ");
		for (int i = 0; i < itemsIndex.size(); i++) {
			System.out.print(itemsIndex.get(i) + " ");
		}
		System.out.println("}");
		
	}
	
}
