#include <array>
#include <algorithm>
#include <iostream>

using coin_t = int;
constexpr size_t MAX_ITEMS_COUNT = 12 * 1024 * 1024;

class coins_stack_t {
public:
    void push_coin(coin_t coin) {
        m_coins[m_size++] = coin;
    }

    coin_t pop_coin() {
        if (m_size == 0 && m_overflow) {
            m_overflow = false;
            m_size = m_size_before_overflow;
        }
        return m_coins[--m_size];
    }

    void duplicate() {
        if (m_size * 2 >= MAX_ITEMS_COUNT) {
            m_overflow = true;
            m_size_before_overflow = m_size;
            return;
        }
        std::copy_n(m_coins.begin(), m_size, &m_coins[m_size]);
        m_size *= 2;
    }

private:
    std::array<coin_t, MAX_ITEMS_COUNT> m_coins = {};
    size_t m_size = 0;

    bool m_overflow = false;
    size_t m_size_before_overflow = 0;
};

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    size_t iters_count = 0;
    coin_t cmd = 0;

    std::cin >> iters_count;
    coins_stack_t coins_stack;
    for (size_t i = 0; i < iters_count; ++i) {
        std::cin >> cmd;
        if (cmd == -1) {
            std::cout << coins_stack.pop_coin() << '\n';
        } else if (cmd == 0) {
            coins_stack.duplicate();
        } else {
            coins_stack.push_coin(cmd);
        }

    }
    std::cout.flush();
    return 0;
}