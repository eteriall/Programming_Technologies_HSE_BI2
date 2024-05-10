import random

minn = 10
maxn = 1000
parts = 49

с = 0
for i in range(minn, maxn, (maxn - minn) // parts):
    n = i
    с += 1
    with open(f"numbers_{с}.txt", mode="w+") as f:
        f.write(' '.join(map(str, [random.randint(1, 10) for _ in range(n)])))
