import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		int T = scan.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = scan.nextInt();
			int[][] map = new int[n][n];
			String[] m2;
		for(int i = 0; i < n; i++) {
			String m = new String();
			m = scan.next();
			m2 = m.split("");
			for(int j = 0; j< n; j++) {
				map[i][j] = Integer.parseInt(m2[j]);
				
				}
			}		
		int sum = 0;
		int d = 0;
        for(int i=0; i < n; i++) {
        	if(i <= n/2) {
        		for(int j=n/2 - d; j<=n/2 + d; j++) {
        			sum += map[i][j];
            		}
        		d++;
        		if(i == n/2)d--;
        		}
        	else if(i > n/2) {
            	d --;
            	for(int j=n/2 - d; j<=n/2 + d; j++) {           	
                	sum += map[i][j];
                	}
            	}            	
            }
            System.out.println("#"+t+ " " + sum);
        }       
	}
}

		
	
		
