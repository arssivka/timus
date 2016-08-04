import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> penguinsStat = new HashMap<String, Integer>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.valueOf(input.readLine().trim());
        for (int i = 0; i < lines; ++i) {
            String penguinTypeName = input.readLine().trim();
            Integer penguinTypeCount = penguinsStat.get(penguinTypeName);
            if(penguinTypeCount == null) {
                penguinsStat.put(penguinTypeName, 1);
            } else {
                penguinsStat.put(penguinTypeName, penguinTypeCount.intValue() + 1);
            }
        }

        Iterator it = penguinsStat.entrySet().iterator();
        Map.Entry<String, Integer> penguinType = null;

        while(it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
            if(penguinType == null || pair.getValue() > penguinType.getValue()) {
                penguinType = pair;
            }
        }

        System.out.println(penguinType.getKey());
    }
}
