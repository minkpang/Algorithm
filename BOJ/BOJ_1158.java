import java.util.*;

public class Main {
	static int a = 0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		LinkedList<Integer> link = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++)link.add(i);
		int index = 0;
		int temp = -1;
		for(int j=0; j<N;j++) {
			for(int k=0;k<K;k++) {
				temp = ((temp+1)%link.size());
			}
			result.add(link.get(temp));
			link.remove(temp);
			temp -= 1;
		}		
		System.out.print("<");
		for(int i = 0; i < N - 1; i ++)System.out.print(result.get(i)+", ");
		System.out.print(result.get(N-1));
		System.out.print(">");
	}
}
