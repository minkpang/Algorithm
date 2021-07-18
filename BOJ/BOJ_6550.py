from sys import stdin

def sol(N,M):
    idx = 0
    for i in range(len(M)):
        if M[i] == N[idx]:
            idx += 1
            if idx == len(N):
                return 'Yes'

    return 'No'

while(1):
    line = stdin.readline().strip()
    if not line:
        break
    A, B = map(str, line.split())
    print(sol(A,B))




