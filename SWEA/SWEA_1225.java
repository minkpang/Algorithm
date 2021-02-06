import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	

		for(int t = 1; t <= 10; t++) {
			int T = scan.nextInt();
			Queue<Integer> queue1 = new LinkedList<Integer>();
			
			for(int i = 0; i < 8; i++)queue1.offer(scan.nextInt());
			int k = 1;
			
			while(true) {
				int s = queue1.poll();
				if(s-k <= 0) {
					queue1.offer(0);
					break;
				}
				queue1.offer(s-k);
				k ++;
				if(k == 6)k = 1;
			}
			System.out.print("#"+ T+ " ");
			for(int j = 0; j < 8; j++) {
				System.out.print(queue1.poll() + " ");
			}
		}			
	}
}