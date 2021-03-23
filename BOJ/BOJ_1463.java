import java.util.*;

public class Main {
	
	public static int[] tb = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		for(int i = 2; i <= x; i++) {
			tb[i] = tb[i-1] + 1;
			
			if(i % 2==0)
				tb[i] = Math.min(tb[i], tb[i/2]+1);
			if(i % 3==0)
				tb[i] = Math.min(tb[i], tb[i/3]+1);
		}
		System.out.println(tb[x]);
		
	}
}
