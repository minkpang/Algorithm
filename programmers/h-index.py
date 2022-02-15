def solution(citations):
    citations.sort()
    for idx , citation in enumerate(citations):
        print(idx)
        if citation >= len(citations) - idx :
            return len(citations) - idx
    return 0