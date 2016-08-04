import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static double getThreadLength(Position[] pos, double radius) {
        double length = 2 * Math.PI * radius;
        for(int i = 0; i < pos.length; ++i) {
            length += Math.sqrt(Math.pow(pos[i].x - pos[(i + 1) % pos.length].x, 2.0)
                    + Math.pow(pos[i].y - pos[(i + 1) % pos.length].y, 2.0));
        }

        return length;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String line = input.readLine();
        StringTokenizer firstLine = new StringTokenizer(line, " ");
        int count = Integer.valueOf(firstLine.nextToken());
        double radius = Double.valueOf(firstLine.nextToken());

        Position[] positions = new Position[count];
        for(int i = 0; i < count; ++i) {
            line = input.readLine();
            StringTokenizer posLine = new StringTokenizer(line, " ");
            positions[i] = new Position();
            positions[i].x = Double.valueOf(posLine.nextToken());
            positions[i].y = Double.valueOf(posLine.nextToken());
        }

        System.out.format("%.2f",getThreadLength(positions, radius));
    }

    private static class Position {
        public double x = 0.0;
        public double y = 0.0;
    }
}
