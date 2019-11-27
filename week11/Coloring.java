

import java.util.Scanner;

class Main {
	
	private int V, numOfColors;
 
	
	private int[] color;

	private int[][] graph;
	
	private boolean[] visit;
	private int[] result;

	public void graphColor(int[][] g, int noc) {
		
		V = g.length;
		numOfColors = noc;
		color = new int[V];
		visit = new boolean[V];
		result = new int[V];
		graph = g;

		try {
			solve(0);
			System.out.println("NONE");
		} catch (Exception e) {

			
			dfs(0);
		}
	}

	public void solve(int v) throws Exception {

		if (v == V)
			throw new Exception("NONE");

		for (int c = 1; c <= numOfColors; c++) {
			if (isPossible(v, c)) {

				color[v] = c;
				solve(v + 1);

				color[v] = 0;
			}
		}
	}

	public boolean isPossible(int v, int c) {
		for (int i = 0; i < V; i++)
			if (graph[v][i] == 1 && c == color[i])
				return false;
		return true;
	}

	

	public void dfs(int n) {
		
	
		 if(n == color.length){
		        for(int i= 0;i<result.length;i++){
		            System.out.print(result[i] + " ");
		        }System.out.println();
		        
		    }else{
		        for(int i =0;i<color.length;i++){
		            if(!visit[i]) {
		                visit[i] = true;
		                result[n] = color[i];
		                dfs(n + 1);
		                visit[i] = false;
		            }
		        }
		    }
		}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Main gc = new Main();

		int V = scan.nextInt();

		int c = scan.nextInt();

		int[][] graph = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				graph[i][j] = scan.nextInt();

		gc.graphColor(graph, c);

	}
}