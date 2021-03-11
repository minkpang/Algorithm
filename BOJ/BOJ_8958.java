import java.util.*;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<T; i++) {
			String temp = sc.nextLine();
			char[] input = new char[temp.length()];
 			for(int k=0; k<temp.length(); k++) {
				input[k]=temp.charAt(k);
			}
			int sum=0;
			int no=1;
			for(int j=0; j<temp.length(); j++) {
				if(input[j]=='O') {
					sum+=no;
					no++;
				}else {
					no=1;
				}
			}
			System.out.println(sum);
		}
	}
}
