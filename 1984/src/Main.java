import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static double getRadius(int n) {
        return (n <= 2) ? n : 1.0 + (1.0 / Math.sin(Math.PI / (double) n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getRadius(Integer.valueOf(input.readLine())));
    }
}
