import java.util.*;


public class Main_2961 {
	static boolean[] select;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args){	

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] sour = new int[T];
		int[] bitter = new int[T];
		select = new boolean[T];
		for(int i = 0; i < T; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();		
		}
		subset(0,sour,bitter,1,0);
		System.out.println(min);
	}
	
	
	static void subset(int count,int[] arr,int[] arr2,int sum, int mul) {
		if(count == arr.length) {
			for(int i = 0; i<arr.length; i++) {
				if(select[i]==true) {
					mul*=arr[i];
					sum+=arr2[i];			
				}
			}
			int temp = Math.abs(sum-mul);
			if(sum!=0 && temp < min) {
				min = temp;
			}
			return;
		}
		select[count] = true;
		subset(count+1,arr,arr2,sum,mul);
		select[count] = false;
		subset(count+1,arr,arr2,sum,mul);
	}
	
}
