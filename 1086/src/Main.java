import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isPrime(int num) {
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    private static int[] calculatedPrimes = new int[15000];
    private static int calculated = 0;

    public static int getPrime(int number) {
        if(calculated == 0) {
            calculated = 2;
            calculatedPrimes[0] = 2;
            calculatedPrimes[1] = 3;
        }

        for(int i = calculated; i < number; ++i) {
            int value = calculatedPrimes[calculated - 1] + 2;
            while(!isPrime(value)) {
                value += 2;
            }

            calculatedPrimes[calculated] = value;
            calculated++;
        }

        return calculatedPrimes[number - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(input.readLine());
        for(int i = 0; i < count; ++i) {
            System.out.println(getPrime(Integer.valueOf(input.readLine())));
        }
    }
}
