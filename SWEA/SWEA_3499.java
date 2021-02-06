import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_3499 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {	
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] map = new String[N];
			String[] input = br.readLine().split(" ");	
			System.out.print("#"+t+" ");
			int c = N%2 == 0 ? N/2: N/2+1;
			for(int i = 0; i < c; i++) {
				System.out.print(input[i]);
				if(i + c >= N)break;
				System.out.print(" " + input[i + c] + " ");
			}
			System.out.println();
		}
	}
}