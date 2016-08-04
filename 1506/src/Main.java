import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNumbers = scanner.nextInt();
        int columns = scanner.nextInt();
        int rows = countNumbers / columns;
        int lastColumnLength = countNumbers % columns;
        int[] numbers = new int[countNumbers];

        if(lastColumnLength != 0) {
            rows++;
        } else {
            columns++;
        }

        for(int i = 0; i < countNumbers; ++i) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < rows; ++i) {
            int numbersInRow = columns;
            if(lastColumnLength != 0 && i >= lastColumnLength) {
                numbersInRow--;
            }

            for(int j = 0; j < numbersInRow; ++j) {
                int numberId = i;
                if(i > lastColumnLength) {
                    numberId += (j - lastColumnLength) * (columns - 1) + (lastColumnLength) * columns;
                } else {
                    numberId += j * (columns - 2);
                }
                System.out.print(String.format("%4d", numbers[numberId]));
            }
            System.out.println();
        }
    }
}
