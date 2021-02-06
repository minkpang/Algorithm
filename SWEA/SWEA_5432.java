import java.util.*;

public class Solution {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		
		int T = scan.nextInt();
		for(int t = 1; t <= T; t++) {
			int stick = 0;
			int sum = 0;
			Queue <Character> st = new LinkedList<>(); 
			String input = scan.next();
			for(int i = 0; i <input.length(); i++) {
				st.offer(input.charAt(i));
			}
			while(!st.isEmpty()) {
				if(st.poll() == '(') {
					if(st.peek() == ')') {
						sum += stick;//레이저를 만나서, 막대기 수만큼 조각이 추가.
						st.poll();
					}else {
						stick ++;
					}
				}else {
					stick --;//막대기의 끝지점을 만나서, 개수를 줄여줌.
					sum ++;//막대기 끝 조각 한개를 합계에 더해줌. 
				}
			}
			System.out.println("#" + t  + " " + sum);
		}
	}			
}
