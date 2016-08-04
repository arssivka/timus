import java.util.Scanner;

/**
 * Created by arssivka on 9/27/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        System.out.println((second - 1) + " " + (first - 1));
    }
}