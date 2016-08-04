import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = reader.readLine()) != null) {
            boolean stored = false;
            int startPos = 0;
            for(int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if(!stored) {
                    if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                        stored = true;
                        startPos = i;
                    } else {
                        System.out.print(c);
                    }
                } else {
                    if(!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
                        StringBuilder line = new StringBuilder();
                        System.out.print(line.append(str.substring(startPos, i)).reverse());
                        System.out.print(c);
                        stored = false;
                    }
                }
            }

            if(stored) {
                StringBuilder line = new StringBuilder();
                System.out.print(line.append(str.substring(startPos, str.length())).reverse());
            }
            System.out.println();
        }

    }
}
