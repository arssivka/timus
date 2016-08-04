__author__ = 'arssivka'

import sys
import itertools

buttons = {
    'i': '1',
    'j': '1',
    'a': '2',
    'b': '2',
    'c': '2',
    'd': '3',
    'e': '3',
    'f': '3',
    'g': '4',
    'h': '4',
    'k': '5',
    'l': '5',
    'm': '6',
    'n': '6',
    'p': '7',
    'r': '7',
    's': '7',
    't': '8',
    'u': '8',
    'v': '8',
    'w': '9',
    'x': '9',
    'y': '9',
    'o': '0',
    'q': '0',
    'z': '0'
}

def readNumber():
    phone = input()
    while True:
        if(phone == '-1'): return
        count = int(input())
        words = [input() for word in range(count)]
        yield (phone, words)
        phone = input()

def check(number, words):
    global buttons
    for (index, letter) in enumerate(''.join(words)):
        if number[index] != buttons[letter]: return False
    return True

if __name__ == '__main__':
    for (phone, words) in readNumber():
        line = None
        plen = len(phone)
        for combinations in [itertools.combinations(words, i + 1) for i in range(len(words))]:
            for combination in combinations:
                if not combination or sum([len(w) for w in combination]) != plen or not check(phone, combination):
                    continue
                elif line == None or len(line) > len(combination):
                    line = combination
        print(' '.join(line) if line != None else 'No solution.')

