import java.util.*;

public class Main {
	static int N;
	static boolean[] visit;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		makecomb(0, 0);
		System.out.println(min);
	}

	private static void makecomb(int cnt, int start) {
		if (cnt == N / 2) {
			int t_s = 0;
			int t_l = 0;

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] == true && visit[j] == true) {
						t_s += map[i][j];
						t_s += map[j][i];
					} else if (visit[i] == false && visit[j] == false) {
						t_l += map[i][j];
						t_l += map[j][i];
					}
				}
			}

			int temp = Math.abs(t_s - t_l);
			if (temp == 0) {
				System.out.println(temp);
				System.exit(0);
			}
			min = Math.min(temp, min);

			return;
		}
		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				makecomb(cnt + 1, i + 1);
				visit[i] = false;
			}

		}
	}

}
