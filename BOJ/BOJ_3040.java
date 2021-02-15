import java.util.Scanner;

public class BOJ_3040 {
	static int[] input = new int[9];
	static int[] select = new int[7];
	static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++)input[i]=sc.nextInt();
        comb(0,0);
        
    }
    public static void comb(int count, int start) {
    	if(count == 7) {
    		for(int j = 0; j < 7; j++)sum+=select[j];
    		if(sum==100) {
    			for(int j = 0; j < 7; j++)System.out.println(select[j]);
    		}
    		sum = 0;
    		return;
    	}
    	for(int i = start; i < 9; i++) {
    		select[count] = input[i];
    		comb(count+1,i+1);
    	}
    	
    	
    }
}