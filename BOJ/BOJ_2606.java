import java.util.*;

public class Main {
	static int[][] map; //2차원 배열로 인접행렬 	
	static int[] check; //방문 체크배열 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		
		map = new int[N+1][N+1];
		check = new int[N+1];
		
		for(int i=0; i<P; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		bfs(1);
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		check[start] = 1;
		int cnt=0;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1; i<map.length; i++) {
				if(map[x][i]==1 && check[i]!=1) {
					check[i]=1;
					cnt++;
					q.offer(i);
				}
			}
		}
		System.out.println(cnt);
	}
}
