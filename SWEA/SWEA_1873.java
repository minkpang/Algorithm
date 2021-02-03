import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // test_case 수 
		for(int test = 1; test <= T; test++) {
			int ylen = sc.nextInt();
			int xlen = sc.nextInt();
			int xindex = 0;
			int yindex = 0;
			char[][] map = new char[ylen][xlen];
			for(int i = 0; i < ylen; i++) {
				String m = new String();
				m = sc.next();
				for(int j = 0; j< xlen; j++) {
					map[i][j] = m.charAt(j);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						xindex = j;
						yindex = i;
					}
				}
			}
			for(int i = 0; i < ylen; i++) {
				for(int j = 0; j < xlen; j++) {
					
				}
			}
		
			int count = sc.nextInt();
			String move = new String();
			move = sc.next();
			char[] mov = new char[count];
			for(int i = 0; i < count; i++) {
				mov[i] = move.charAt(i);
			}
				
			for(int j = 0; j < count; j++) {
				if(mov[j] == 'S') {
					int d = 1;
					boolean shot = false;
					if((yindex < ylen && yindex >=0) && (xindex < xlen && xindex >=0) && map[yindex][xindex] == '^') {
						while(shot != true) {
							if(yindex - d < 0) {
								break;
							}
							if(yindex - d >= 0 && map[yindex - d][xindex] == '*' || map[yindex - d][xindex] == '#') {
								shot = true;
								d--;
							}
							d ++;
						}
						if(yindex - d >= 0) {
							if(map[yindex - d][xindex] == '*') {
								map[yindex - d][xindex] = '.';
							}else if(map[yindex - d][xindex] == '#') {
								map[yindex - d][xindex] = '#';
							}
						}
					}else if((yindex < ylen && yindex >=0) && (xindex < xlen && xindex >=0) && map[yindex][xindex] == 'v') {
						while(shot != true) {
							if(yindex + d >= ylen) {
								break;
							}
							if(map[yindex + d][xindex] == '*' || map[yindex + d][xindex] == '#') {
								shot = true;
								d--;
							}
							d ++;
						}
						if(yindex + d < ylen) {
							if(map[yindex + d][xindex] == '*') {
								map[yindex + d][xindex] = '.';
							}else if(map[yindex + d][xindex] == '#') {
								map[yindex + d][xindex] = '#';
							}
						}
					}else if((yindex < ylen && yindex >=0) && (xindex < xlen && xindex >=0) && map[yindex][xindex] == '<') {
						while(shot != true) {
							if(xindex - d < 0) {
								break;
							}
							if(map[yindex][xindex - d] == '*' || map[yindex][xindex - d] == '#') {
								shot = true;
								d--;
							}
							d ++;
						}
						if(xindex - d >= 0) {
							if(map[yindex][xindex - d] == '*') {
								map[yindex][xindex - d] = '.';
							}else if(map[yindex][xindex - d] == '#') {
								map[yindex][xindex - d] = '#';
							}
						}
					}else if((yindex < ylen && yindex >=0) && (xindex < xlen && xindex >=0) && map[yindex][xindex] == '>') {
						while(shot != true) {
							if(xindex + d >= xlen) {
								break;
							}
							if(xindex + d < xlen && map[yindex][xindex + d] == '*' || map[yindex][xindex + d] == '#') {
								shot = true;
								d --;
							}
							
							d ++;
						}
						if(xindex + d < xlen) {
							if(map[yindex][xindex + d] == '*') {
								map[yindex][xindex + d] = '.';
							}else if(map[yindex][xindex + d] == '#') {
								map[yindex][xindex + d] = '#';
							}
						}
					}
					
				}
				else if(mov[j] == 'U') {
					if(yindex - 1 < 0 || map[yindex - 1][xindex] == '-' || map[yindex - 1][xindex] == '*' || map[yindex - 1][xindex] == '#') {
						map[yindex][xindex] = '^';
						continue;
					}
					map[yindex][xindex] = '.';
					map[yindex - 1][xindex] = '^';
					yindex --;
				}else if(mov[j] == 'D') {
					if(yindex + 1 >= ylen ||map[yindex + 1][xindex] == '-' || map[yindex + 1][xindex] == '*' || map[yindex + 1][xindex] == '#') {
						map[yindex][xindex] = 'v';
						continue;
					}
					map[yindex][xindex] = '.';
					map[yindex + 1][xindex] = 'v';
					yindex ++;
				}else if(mov[j] == 'R') {
					if(xindex + 1 >= xlen  ||map[yindex][xindex + 1] == '-' || map[yindex][xindex + 1] == '*' || map[yindex][xindex + 1] == '#') {
						map[yindex][xindex] = '>';
						continue;
					}
					map[yindex][xindex] = '.';
					map[yindex][xindex + 1] = '>';
					xindex ++;
				}else if(mov[j] == 'L') {
					if(xindex - 1 < 0 ||map[yindex][xindex - 1] == '-' || map[yindex][xindex - 1] == '*' || map[yindex][xindex -1] == '#') {
						map[yindex][xindex] = '<';
						continue;
					}
					map[yindex][xindex] = '.';
					map[yindex][xindex - 1] = '<';
					xindex --;
				}
				
			}
			System.out.print("#" + test+" ");
			System.out.println();
			for(int i = 0; i < ylen; i++) {
				for(int j = 0; j < xlen; j++) {
					System.out.print(map[i][j] );
				}
				System.out.println();
			}
		}
	}
}
 