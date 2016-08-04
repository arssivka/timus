if __name__ == '__main__':
    data = [int(x) for x in input().split()]
    out = [x for x in range(data[1]) if x ** data[0] % data[1] == data[2]]
    print(' '.join([str(elem) for elem in out]) if len(out) != 0 else '-1')
