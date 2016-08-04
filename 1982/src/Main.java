import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int nCities = scanner.nextInt();
        int nStations = scanner.nextInt();
        boolean[] electrified = new boolean[nCities];
        int[] groupCities = new int[nCities];

        Arrays.fill(electrified, false);
        for(int i = 0; i < nCities; ++i) {
            groupCities[i] = i;
        }

        for(int i = 0; i < nStations; ++i) {
            int cityId = scanner.nextInt() - 1;
            electrified[cityId] = true;
        }


        int constructionCost[][] = new int[nCities][nCities];
        for(int i = 0; i < nCities; ++i) {
            for(int j = 0; j < nCities; ++j) {
                constructionCost[i][j] = scanner.nextInt();
            }
        }


        int totalPrice = 0;
        for(int i = 0; i < nCities; ++i) {
            if(electrified[i]) {
                continue;
            }

            int cityIdA = -1;
            int cityIdB = -1;

            for(int j = 0; j < nCities; ++j) {
                if(groupCities[i] != groupCities[j]) {
                    continue;
                }

                for (int k = 0; k < nCities; ++k) {
                    if (j == k || groupCities[j] == groupCities[k]) {
                        continue;
                    }

                    if (cityIdA == -1 || constructionCost[j][k] < constructionCost[cityIdA][cityIdB]) {
                        cityIdA = j;
                        cityIdB = k;
                    }
                }
            }

            int groupId = groupCities[cityIdB];

            for(int j = 0; j < nCities; ++j) {
                if(groupCities[j] == groupId) {
                    groupCities[j] = groupCities[cityIdA];
                }
            }

            totalPrice += constructionCost[cityIdA][cityIdB];
        }

        System.out.println(totalPrice);
    }
}
