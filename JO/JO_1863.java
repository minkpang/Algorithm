import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	private static int N, M;
	private static int[] parents;
	private static int[] rank;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 처음으로 문제 채점을 하면서, Scanner를 BufferedReader로 바꿔서 채점에 통과.
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		rank = new int[N + 1];

		Arrays.fill(parents, -1);

		for (int i = 0; i < M; ++i) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		int cnt = 0;
		for (int j = 1; j <= N; j++) {

			if (j == find(j)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static int find(int a) {
		if (parents[a] == -1)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int pa = find(a); 
		int pb = find(b); 

		if (pa == pb)
			return;

		if (rank[pa] > rank[pb])
			parents[pb] = pa;
		else {
			parents[pa] = pb;
			if (rank[pa] == rank[pb]) {
				rank[pb]++;
			}
		}
	}
}