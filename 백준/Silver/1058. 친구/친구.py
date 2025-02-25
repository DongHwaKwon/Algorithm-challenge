import sys
input = sys.stdin.readline

INF = int(1e9)

N = int(input())

graph = [[INF] * (N+1) for _ in range(N+1)]

for a in range(1, N + 1):
    for b in range(1, N + 1):
        if a == b:
            graph[a][b] = 0

for i in range(1, N + 1):
    cost = [x for x in input().strip()]
    for j in range(1, N+1):
        if cost[j-1] == 'Y':
            graph[i][j] = 1

for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

ans = 0
cos = 0
for a in range(1, N + 1):
    cos = 0
    for b in range(1, N + 1):
        if graph[a][b] <= 2:
            cos += 1
    ans = max(ans, cos)
print(0) if N == 1  else print(ans-1)