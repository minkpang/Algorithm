import sys

key = ['qwertyuiop','asdfghjkl','zxcvbnm'] # 4, 4 , 3

l,r = map(str,sys.stdin.readline().split())
ans = sys.stdin.readline().rstrip()

res = 0
lidx = [0,0]
ridx = [0,0]

for i in range(3):
    if l in key[i]:
        lidx[1] = key[i].index(l)
        lidx[0] = i

for i in range(3):
    if r in key[i]:
        ridx[1] = key[i].index(r)
        ridx[0] = i

for k in ans:
    tidx = [0,0]
    for i in range(3):
        if k in key[i]:
            tidx[1] = key[i].index(k)
            tidx[0] = i
    if (tidx[0] < 2 and tidx[1] < 5) or (tidx[0] == 2 and tidx[1] < 4):
        res += abs(lidx[0] - tidx[0]) + abs(lidx[1] - tidx[1]) + 1
        lidx = [tidx[0], tidx[1]]
    else:
        res += abs(ridx[0] - tidx[0]) + abs(ridx[1] - tidx[1]) + 1
        ridx = [tidx[0], tidx[1]]


print(res)