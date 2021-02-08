import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1228 {
	
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		
		for(int o = 1; o <= 10; o++) {
			int N = sc.nextInt();
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int t = 1; t <= N; t++)	result.add(sc.nextInt());	

			int P = sc.nextInt();
			for(int i = 0; i < P; i++) {
				sc.next();
				int index = sc.nextInt();
				int c = sc.nextInt();
				Stack<Integer> stack = new Stack<Integer>();
				for(int j = 0; j < c; j++) {	
					stack.push(sc.nextInt());
				}
				while(!stack.isEmpty()) {
					result.add(index,stack.pop());
				}
			}
			System.out.println("#" + o +" ");
			for(int k = 0; k < 10; k++) {
				System.out.print(result.get(k) + " ");
			}System.out.println();
		}
	}
}