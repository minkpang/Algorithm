import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);

		int N;
		int index;
		int[][] map = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = sc.nextInt();
			index = 0;

			

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2)index = j;
				}
			}
		int k = 99;
		while(k > 0) {
			if((index - 1 > 0 && index + 1 < 100) && map[k][index - 1]== 0 && map[k][index + 1]== 0) {
				k--;
			}else if(index - 1 >= 0 && map[k][index - 1] == 1) {
				while(index - 1 >= 0 && map[k][index-1] != 0 ) {
					index --;
				}
				k --;
			}else if(index + 1 < 100 && map[k][index + 1] == 1) {
				while(index + 1 < 100 && map[k][index+1] != 0) {
					index ++;
				}
				k --;
			}else {
				k --;
			}
		}
			System.out.println("#" + N + " " + index);
		}
	}

}
 