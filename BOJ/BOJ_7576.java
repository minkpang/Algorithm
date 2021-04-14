import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_tomato {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] xdir = { 1, -1, 0, 0 };
		int[] ydir = { 0, 0, 1, -1 };

		int M = sc.nextInt(); // 가로
		int N = sc.nextInt(); // 세로
		int[][] map = new int[N][M]; //1만큼 상하좌우 움직이는 map 
		int ans = 0;
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M]; 

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					queue.offer(new Node(i, j, 0)); //토마토가 익은친구들은 바로 큐에 넣어주기 
				}
			}
		}
		int cnt = 0;
		// 큐에서 더이상 노드가 없을때까지 
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			//카운트가 가장 큰 친구를 갱신 
			if (cnt < node.cnt) {
				cnt = node.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int dx = node.x + xdir[i];
				int dy = node.y + ydir[i];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if (!visited[dx][dy] && map[dx][dy] == 0) { //0일때만 BFS동작 
						map[dx][dy] = 1;
						visited[dx][dy] = true;
						queue.add(new Node(dx, dy, cnt + 1));
					}
				}
			}

		}
		//결과에서 아직 익지못한 토마토가 하나라도 있는 경우에 -1을 출력하고 코드 종료.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(cnt);
	}

	static class Node {
		int x, y, cnt;
		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
