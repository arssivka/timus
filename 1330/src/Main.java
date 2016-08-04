import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(input.readLine());
        int[] sensors = new int[n + 1];
        sensors[0] = 0;
        for(int i = 1; i <= n; ++i) {
            sensors[i] = Integer.valueOf(input.readLine()) + sensors[i - 1];
        }

        int q = Integer.valueOf(input.readLine());
        for(int i = 0; i < q; ++i) {
            StringTokenizer line = new StringTokenizer(input.readLine());
            int first = Integer.valueOf(line.nextToken()) - 1;
            int last = Integer.valueOf(line.nextToken());
            System.out.println(sensors[last] - sensors[first]);
        }
    }
}
