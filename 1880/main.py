import functools

def input2set():
    input()
    return set([int(s) for s in input().split()])

def main():
    print(len(functools.reduce(lambda acc, x: acc & x, [input2set() for i in range(3)])))

if __name__ == '__main__':
    main()
