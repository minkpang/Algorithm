import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] input = new int[N][2];
        
        
        for(int i = 0; i < N;i++) {
        	input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();        
        }
        Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
        
        ArrayList<int[]> res = new ArrayList<int[]>();
        res.add(input[0]);
        int count = 1;
        
        for(int j = 0; j < input.length; j++) {
        	if(res.get(res.size()-1)[1] <= input[j][0]) { //온도가 겹치지 않는다면, 새로 추가하고 카운트 증
        		res.add(input[j]);
        		count ++;
        	}
        }  
        System.out.println(count); //결과 출
    }
}  
