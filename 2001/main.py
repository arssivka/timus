if __name__ == '__main__':
    m1 = [int(s) for s in input().split()]
    m2 = [int(s) for s in input().split()]
    m3 = [int(s) for s in input().split()]
    print(' '.join([str(m1[0] - m3[0]), str(m1[1] - m2[1])]))