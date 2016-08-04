def count(pos):
    dot = (ord(pos[0]) - ord('a'), int(pos[1]) - 1)
    return len([True for d in count.dots if 0 <= dot[0] + d[0] < 8 and 0 <= dot[1] + d[1] < 8])

count.dots = [(1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1), (-2, 1), (-1, 2)]

if __name__ == '__main__':
    print('\n'.join([str(count(input())) for i in range(int(input()))]))
