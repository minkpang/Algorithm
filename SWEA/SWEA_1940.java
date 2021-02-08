import java.util.Scanner;

public class SWEA_1940 {
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int sum = 0;
			int speed = 0;
			for(int i = 0; i < N; i++) {
				int type = sc.nextInt();
				if(type == 0) {
					sum += speed;
					continue;
				}
				int amount = sc.nextInt();
				if(type == 1)speed += amount;
				else if(type == 2) {
					speed -= amount;
					if(speed < 0)speed = 0;
				}
				sum += speed;
			}System.out.println("#" + t + " " + sum);
		}
	}
}