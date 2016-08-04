if __name__ == '__main__':
    n = int(input());
    print(sum(range(1, n + 1) if n >= 1 else range(1, n - 1, -1)))