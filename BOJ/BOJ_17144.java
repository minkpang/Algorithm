import java.util.*;

public class Main_미세 {
	static int[][] map;
	static int R,C,T;
	static int[] xdir = { 1, -1, 0, 0 };
	static int[] ydir = { 0, 0, 1, -1 };
	static int[] air = new int[2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		int po = 0;//공기청정기 포지션;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==-1) {
					air[po]=i;
					po++;
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			spread();
			aircleaner();
			System.out.println(t);
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==-1)continue;
				result += map[i][j];
			}
		}
		System.out.println(result);
		//미세먼지 확산까지 

	}

	private static void aircleaner() {
		int up = air[0];
		int down = air[1];
		
		for(int i = up-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int j = 0; j < C-1; j++) {
			map[0][j] = map[0][j+1];
		}
		for(int i = 0; i < up; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int j = C-1; j > 1; j--) {
			map[up][j] = map[up][j-1];
		}
		map[up][1] = 0;
		
		for(int i = down+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int j = 0; j < C-1; j++) {
			map[R-1][j] = map[R-1][j+1];
		}
		for(int i = R-1; i > down; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int j = C-1; j > 1; j--) {
			map[down][j] = map[down][j-1];
		}
		map[down][1] = 0;
		
		map[up][0] = -1;
		map[down][0] = -1;
	}

	private static void spread() {
		int[][] temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int dx = j + xdir[k];
						int dy = i + ydir[k];
						if (dx >= 0 && dx < C && dy >= 0 && dy < R&&map[dy][dx]!=-1) {
							temp[dy][dx] += (map[i][j] / 5);
							cnt++;
						}
					}
					temp[i][j] += map[i][j] - ((map[i][j]/5)*cnt);
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
		
	}
}
