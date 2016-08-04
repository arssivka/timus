from functools import reduce
import operator

if __name__ == '__main__':
    data = input().split()
    print(reduce(operator.mul, range(int(data[0]), 0, -len(data[1])), 1))
