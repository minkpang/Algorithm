import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {	
		
		for(int t = 1; t <= 10; t++) {
			boolean check = false;
			Stack<Integer> stack1 = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			Stack<Integer> stack3 = new Stack<>();
			Stack<Integer> stack4 = new Stack<>();
			
			int N = scan.nextInt();
			char[] map = new char[N];
			String input = scan.next();
			
			for(int i = 0; i< N; i++) {
				map[i] = input.charAt(i);
			}
			int i = 0;
			while( i!= N ) {
				if(map[i] == '(')stack1.push(1);
				else if(map[i] == '{')stack2.push(2);
				else if(map[i] == '[')stack3.push(3);
				else if(map[i] == '<')stack4.push(4);
				
				if(map[i] == ')') {
					if(stack1.isEmpty())break;
					stack1.pop();
				}
				else if(map[i] == '}') {
					if(stack2.isEmpty())break;
					stack2.pop();
				}
				else if(map[i] == ']') {
					if(stack3.isEmpty())break;
					stack3.pop();
				}
				else if(map[i] == '>') {
					if(stack4.isEmpty())break;
					stack4.pop();
				}
				i ++;
			}
			if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty()) {
				check = true;
			}
			int c = check == true? 1:0;
			System.out.println("#"+ t+ " " +c);
		}			
	}
}

		
	
		
