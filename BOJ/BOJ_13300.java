import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int K = sc.nextInt();
        int[][] res = new int[7][2];
        for( int i=0; i < T; i++) {
        	int S = sc.nextInt();
        	int Y = sc.nextInt();
        	res[Y][S]++;
        }
        int tot = 0;
        for(int j=1; j < 7; j++) {
        	tot += ceil(K,res[j][0]);
        	tot += ceil(K,res[j][1]);
        }
        System.out.println(tot);
        
	}
	static int ceil(int k, int n) {
		return (int)(Math.ceil(1.0*n/k));
	}
	
}  
