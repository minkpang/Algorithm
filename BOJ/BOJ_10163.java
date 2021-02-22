import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] map = new int[101][101];
        int[] result = new int[101];
        for(int k =0; k < T; k++) {
        	int c = sc.nextInt();
        	int r = sc.nextInt();
        	int w = sc.nextInt();
        	int h = sc.nextInt();
        	for(int i = c; i < c+w; i++) {
        		for(int j = r; j < r+h; j++) {
        			map[i][j] = (k+1);
        		}
        	}
		}
        for(int i=0; i < 101; i++) {
        	for(int j=0; j<101;j++) {
        		result[map[i][j]]++;
        	}
        }
        for(int i=1; i<=T;i++) {
        	System.out.println(result[i]);
        }
	}
}  
