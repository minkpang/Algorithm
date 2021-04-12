import java.util.*;
 
public class Solution_보급로 {
    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};
    static int n;
    static int[][] map;
    static int[][] res;
    static boolean[][] visit;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();  
        for(int tc=1; tc <= TC; tc++) {
            n = sc.nextInt();
            visit = new boolean[n][n];
             
            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                String[] temp = sc.next().split("");
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            res = new int[n][n];
            res[0][0] = 0;
            bfs(0,0);
            System.out.println("#"+tc+" "+res[n-1][n-1]);
             
        }
    }
    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
         
        q.offer(new Point(i,j));
        visit[i][j] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int a = p.x;
            int b = p.y;            
            for(int k=0; k<4; k++) {
                int dx = a + xdir[k];
                int dy = b + ydir[k];
                if(dx >= 0 && dx < n && dy >= 0 && dy < n) {
                    if(!visit[dx][dy]||res[dx][dy] > res[a][b] + map[dx][dy]) {
                        visit[dx][dy] = true;
                        res[dx][dy] = res[a][b] + map[dx][dy];
                        q.offer(new Point(dx,dy));
                    }
                }
            }
        }       
    }   
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}