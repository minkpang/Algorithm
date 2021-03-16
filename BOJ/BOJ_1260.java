import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution{
	static int N;
	static boolean matrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		int start = sc.nextInt();
		
		matrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			matrix[to][from] = matrix[from][to] = true;
		}
		dfs(start);
		System.out.println();
		bfs(start);
		
	}
	private static boolean[] visited;
	private static void dfs(int current) {
		visited[current] = true;
		System.out.print(current+" ");
		for(int i=0; i<=N; ++i) {
			if(matrix[current][i]&&!visited[i]) {
				dfs(i);
			}
		}
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		
		int current = start;
		queue.offer(current);
		visited[current] = true;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current+" ");
			for(int i=0; i<=N; ++i) {
				if(matrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}