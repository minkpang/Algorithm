import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		int T = scan.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int sum = 0;
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[][] map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[j][i] = scan.nextInt();
				}
			}
			
			int max = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.println(j);
					for(int k = 0; k < m; k++) {
						if(j+k >= n)break;
						for(int l = 0; l < m; l++) {
							if(i+l >= n)break;
							else {
								sum += map[j+k][i+l];
								System.out.println(i + " " + j);
								System.out.println(sum);
							}								
						}
					}if(sum > max)max = sum;
					sum = 0;
				}
			}
			
            System.out.println("#"+t+ " " + max);
        }       
	}
}

		
	
		
