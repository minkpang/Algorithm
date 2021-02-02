import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // test_case 수 
		for(int test = 1; test <= T; test++) {
			int len = sc.nextInt(); // 배열 크기 
			int[][] map = new int[len][len];
			int num = 1; 
			int x = -1;
			int y = 0;
			int p = 1;
			int n = len;
			while(n > 0) {
				for(int i = 0; i< n; i++) {
					x += p;
					map[y][x] = num;
					num++;			
				}
				n --;
				for(int j = 0; j<n; j++) {
					y += p;
					map[y][x] = num;
					num++;
				}
				p = p*-1;
			}
			System.out.println("#" + test);
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
 