from itertools import combinations

mo = ('a', 'e', 'i', 'o', 'u')
l, c = map(int, input().split(' '))

inputChar = input().split(' ')
inputChar.sort()
res = list(combinations(inputChar,l))

for temp in res:
    cnt = 0
    for i in temp:
        if i in mo:
            cnt += 1

    if cnt >= 1 and cnt <= l - 2:
        print(''.join(temp))