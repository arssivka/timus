import math

if __name__ == '__main__':
    count = int(input())
    groups = sorted([int(group) for group in input().split()])
    print(sum([math.floor(groups[id] / 2) + 1 for id in range(math.floor(count / 2) + 1)]))
