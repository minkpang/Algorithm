from sys import stdin

T = int(stdin.readline().rstrip())
cows = [-1] * 11
count = 0

for i in range(T):
    N, M = map(int, stdin.readline().split())
    if cows[N] == -1:
        cows[N] = M
    else:
        if cows[N] != M:
            count += 1
            cows[N] = M

print(count)