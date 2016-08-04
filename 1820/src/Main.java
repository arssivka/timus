import java.util.Scanner;

/**
 * Created by arssivka on 9/27/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long first = scanner.nextLong();
        long second = scanner.nextLong();

        long result = 2 * (first / second);
        if(first % second != 0  ) {
            result += 1;
        }

        if(first % second > second / 2 || first < second) {
            result += 1;
        }

        System.out.println(result);
    }
}
