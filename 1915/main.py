from copy import deepcopy, copy


class CoinStack:
    def __init__(self, coins=[], clones=0, child=None):
        self._coins = coins
        self._clones = clones
        self._child = child
        self._bottom = [self]
        self._update_bottom()

    def push(self, coin):
        if self._clones == 0:
            self._coins.append(coin)
        else:
            self._child = copy(self)
            self._update_bottom()
            self._coins = [coin]
            self._clones = 0

    def clone(self):
        self._clones += 1

    def pop(self):
        while self._clones > 0:
            self._clones -= 1
            bottom._child = deepcopy(self)
            self._update_bottom()
        coin = self._coins.pop()
        if len(self._coins) == 0 and self._child:
            self._coins = self._child._coins
            self._clones = self._child._clones
            self._child = self._child._child
        return coin

    def _update_bottom(self):
        while self._bottom[0]._child:
            self._bottom[0] = self._bottom[0]._child


stack = CoinStack()
n = int(input())
for i in range(n):
    act = int(input())
    if act > 0:
        stack.push(act)
    elif act == 0:
        stack.clone()
    else:
        print(stack.pop())