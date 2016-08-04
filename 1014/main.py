if __name__ == '__main__':
    n = int(input())
    if n == 1:
        print(1)
    elif n == 0:
        print(10)
    else:
        ans = []
        for div in [x for x in range(9, 1, -1) if n % x == 0]:
            while n % div == 0:
                n /= div
                ans.append(div)
            if n == 1: break
        ans.reverse()
        print(''.join([str(d) for d in ans]) if n == 1 else '-1')
