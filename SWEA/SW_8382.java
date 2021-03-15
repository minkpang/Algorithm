import java.util.*;


public class Solution {
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			int b1 = sc.nextInt();
			int b2 = sc.nextInt();
			int sum = a1+a2+b1+b2;
			int result = 0;
			int max = Math.max(Math.abs(a1-b1), Math.abs(a2-b2));
			result = max*2;
			if(sum%2==1)result--;
			System.out.println(result);
		}
	}
}