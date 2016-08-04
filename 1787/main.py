import functools

def main():
    carspermin = int(input().split()[0])
    print(functools.reduce(lambda acc, x: acc + x if acc + x > 0 else 0, [int(s) - carspermin for s in input().split()], 0))

if __name__ == '__main__':
    main()
