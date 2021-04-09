from collections import deque

n = int(input())
p = int(input())
map2 = [[0]*(n+1) for i in range(n+1)]
visit = [0 for _ in range(n+1)]
for i in range(p):
    a,b = map(int, input().split())
    map2[a][b] = 1
    map2[b][a] = 1
q = deque([1])
visit[1] = 1
cnt = 0
while q:
    x = q.popleft();
    for i in range(n+1):
        if map2[x][i] == 1 and visit[i]!=1:
            cnt += 1
            visit[i]=1
            q.append(i)
print(cnt)






