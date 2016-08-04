import operator

def main():
    l = int(input())
    force = [int(f) for f in input().split()]
    maxforce = list(max(enumerate([sum(force[i:i + 3]) for i in range(l - 2)]), key=operator.itemgetter(1)))
    maxforce.reverse()
    maxforce[1] += 2
    print(" ".join([str(e) for e in maxforce]));

if __name__ == '__main__':
    main()
