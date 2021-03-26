import java.util.Arrays; //출력해볼때 사용함 
import java.util.Scanner; //입력받을때 사용함 

public class Main_14502 {
	public static int n; //세로크기 
	public static int m; //가로크기
	public static int res; //결과값을 넣어줄 변수 
	public static int[][] map = new int[8][8]; //입력을 받은 지도 
	public static int[][] afterVmap = new int[8][8]; //벽설치후 바이러스가 퍼진 상태 지도 
	
	public static int[] dx = {1,-1,0,0}; //이동할 델타배열 x
	public static int[] dy = {0,0,1,-1}; //이동할 델타배열 y
	
	public static void main(String[] args) { //main 함수 
		Scanner sc = new Scanner(System.in); //정수값이 구분되어서 들어올때 편함 
		
		n = sc.nextInt();
		m = sc.nextInt();
		//입력 단계
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//입력 끝 
		dfs(0); // 
		System.out.println(res); //결과 출력 
	}
	
	public static void sperad(int x, int y) { //바이러스가 퍼지도록 해준다 
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if(afterVmap[nx][ny] == 0) {
					afterVmap[nx][ny] = 2;
					sperad(nx, ny); //재귀로 spread 함수를 타면서, 바이러스 전파. dfs 
				}
			}	
		}
		return;
	}
	
	public static void dfs(int cnt) { //dfs 를 돌면서, 벽이 3개 세워지는 상황마다 크기 계산.
		if(cnt == 3) {// 벽을 세운횟수 체크 
			for(int i = 0; i < n; i++) { //영역들 체크하기 위해서 map으로 초기화 
				for(int j = 0; j < m; j++) {
					afterVmap[i][j] = map[i][j];
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if (afterVmap[i][j] == 2) { //바이러스는 전파시킨다.
						sperad(i,j);
					}
				}
			}
			
			int temp = 0; //안전 영역 넣어줄 변수.
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(afterVmap[i][j] == 0) { //안전한 영역이면 값을 증가. 
						temp++;
					}
				}
			}
			res = Math.max(res,temp);
			return;
		}
		 
		for(int i = 0; i < n; i++) { //벽을 세운다. 모든 0에 벽을 세우는 조합 
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					cnt++;
					dfs(cnt);
					map[i][j] = 0;
					cnt--;
				}
			}
		}
	}
}
