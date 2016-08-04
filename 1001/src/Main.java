import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList values = new LinkedList();

        while(scanner.hasNext()) {
            Double value = Math.sqrt(scanner.nextDouble());
            values.addFirst(value);
        }

        ListIterator iterator = values.listIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
