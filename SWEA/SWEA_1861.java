import java.util.Scanner;

public class SWEA_1861 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		
		int T = scan.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = scan.nextInt();
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			int max = 0;
			int value = 0;
			for(int i = 0; i < N; i++) {
				for(int j=0; j < N; j++) {
					int count = 0;
					int x = i;
					int y = j;
					while(true) {
						if(x + 1 < N && map[x + 1][y] == (map[x][y] +1)) {
							x++;
							count ++;
						}else if(y + 1 < N && map[x][y+1] == (map[x][y] +1)) {
							y++;
							count ++;
						}else if(x - 1 >= 0 && map[x - 1][y] == (map[x][y] +1)) {
							x--;
							count ++;
						}else if(y - 1 >= 0 && map[x][y - 1] == (map[x][y] +1)) {
							y--;
							count ++;
						}else {
							if(max <= count) {
								if(value == 0 && count != 0)value = map[i][j];
								if(max < count) value = map[i][j];
								if(map[i][j] < value) value = map[i][j];
								max = count;
							}
							break;
						}
					}
				}
			}	
			System.out.println("#" + t  + " " + value + " " + (max + 1));
		}
	}
}
