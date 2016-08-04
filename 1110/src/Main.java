import java.util.Scanner;

/**
 * Created by arssivka on 9/29/14.
 */
public class Main {
    public static int binpow (int a, int n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                res *= a;
            }
            a *= a;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int y = scanner.nextInt();

        boolean find = false;
        for(int i = 0; i < m; ++i) {
            int value = 1;
            for(int j = 0; j < n; ++j) {
                value = (value * i) % m;
            }

            if(value == y) {
                System.out.print(i + " ");
                find = true;
            }
        }

        if(!find) {
            System.out.print("-1");
        }
    }
}
