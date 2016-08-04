def main():
     w, h = [int(i) for i in input().split()]
     state = 0
     count = 0
     while True:
         if state == 0:
             if h == 1:
                 break
             w -= 1
             count += 1
             state = 1
         if state == 1:
             if w == 0:
                 break
             h -= 1
             count += 1
             state = 2
         if state == 2:
             if h == 1:
                 break
             w -= 1
             count += 1
             state = 1
         if state == 3:
             if w == 0:
                 break
             h -= 1
             count += 1
             state = 0
     print(count)



if __name__ == "__main__":
    main()
