import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static int[] getRemoveableBlades(int bladesCount, int[] brokenBlades) {
        int[] blades = new int[bladesCount];
        for(int blade : brokenBlades) {
            blades[blade - 1] = -1;
        }

        int newBladesCount = 0;

        for(int i = 2; i < bladesCount; ++i) {
            if(bladesCount % i != 0) {
                continue;
            }

            int step = bladesCount / i;
            for(int j = 0; j < step; ++j) {
                boolean marked = false;
                for(int k = 0; k < i; ++k) {
                    if(blades[j + step * k] == -1) {
                        marked = true;
                        break;
                    }
                }

                //if(!marked) {
                    newBladesCount += i;
                    for(int k = 0; k < i; ++k) {
                        blades[j + step * k] = i;
                    }
               //}
            }
        }

        int[] remove = new int[newBladesCount];
        int index = 0;
        for(int i = 0; i < bladesCount; ++i) {
            if(blades[i] == 0) {
                System.out.println(i + 1);
                remove[index] = i + 1;
                index++;
            }
        }

        return remove;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bladesCount = scanner.nextInt();
        int brokenBladesCount = scanner.nextInt();
        int[] brokenBlades = new int[brokenBladesCount];

        for(int i = 0; i < brokenBladesCount; ++i) {
            brokenBlades[i] = scanner.nextInt();
        }
        getRemoveableBlades(bladesCount, brokenBlades);
    }
}
