import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {	

		for(int t = 1; t <= 1; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			
			String[] map = new String[N];
			String[] input = br.readLine().split("");	
			StringBuilder sb = new StringBuilder();
			
			Stack<Integer> num = new Stack<Integer>();
			Stack<String> oper = new Stack<String>();
			
			for(int i = 0; i < N; i ++) {
				if(input[i].equals("*")||input[i].equals("+")) {
					if(oper.isEmpty())oper.push(input[i]);
					else {
						if(input[i].equals("*") && oper.peek().equals("*")) {
							sb.append(oper.pop());
							oper.push(input[i]);
						}
						else if(input[i].equals("+") && oper.peek().equals("*")) {
							sb.append(oper.pop());
							while(!oper.isEmpty())sb.append(oper.pop());
							oper.push(input[i]);
						}else if(input[i].equals("*") && oper.peek().equals("+")) {
							oper.push(input[i]);
						}else {
							sb.append(oper.pop());
							oper.push(input[i]);
						}
					}
				}else {
					sb.append(input[i]);
				}
				if(i == N-1) {
					while(!oper.isEmpty())sb.append(oper.pop());
				}
			}
			int a;
			int b;
				for(int i=0; i<sb.length(); i++) {
					if(Character.isDigit(sb.charAt(i))){
						num.push(sb.charAt(i) - '0');
					}else {
						if(sb.charAt(i) == '+') {
							a = num.pop();
							b = num.pop();
							num.push(a+b);
						}else {
							a = num.pop();
							b = num.pop();
							num.push(a*b);
						}
					}
				}
				System.out.println("#" + t+ " " + num.pop());
			}		
		}
	}