import itertools

def main():
    n, m = [int(i) for i in input().split()]
    resistance = [int(i) for i in input().split()]
    groups = [(k, len(list(g))) for k, g in itertools.groupby(sorted(resistance))]
    acc = coins = casts = 0
    g, c = groups[0]
    for g, c in groups:
        if g * (acc + c) > m:
            if acc == 0:
                break
            coins += acc
            casts += 1
            acc = 0
            if(g * c > m):
                break
        acc += c
    else:
        if g * acc <= m:
            coins += acc
            casts += 1
    print(coins, casts)

if __name__ == '__main__':
    main()