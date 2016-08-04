import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ListIterator;

public class Main {
    public static final char[] REPLACING_TABLE = new char[] {
            '2', '2', '2', '3', '3', '3', '4', '4', '1', '1', '5', '5', '6',
            '6', '0', '7', '0', '7', '7', '8', '8', '8', '9', '9', '9', '0'
    };

    public static boolean isWordContainsInNumber(String number, int pos, String word) {
        if(pos + word.length() > number.length()) {
            return false;
        }

        for(int i = 0; i < word.length(); ++i) {
            int index = (int) word.charAt(i) - 'a';
            if(REPLACING_TABLE[index] != number.charAt(pos + i)) {
                return false;
            }
        }

        return true;
    }

    public static List<String> getWordSequence(String number, String[] words) {
        LinkedList<WordSequence> queue = new LinkedList<WordSequence>();
        WordSequence seq = null;

        for(String str : words) {
            queue.addFirst(new WordSequence(str));
        }

        while(!queue.isEmpty()) {
            WordSequence cur = queue.getFirst();
            queue.remove();

            for(String str : words) {
                if(isWordContainsInNumber(number, cur.length, str)) {
                    WordSequence nSeq = new WordSequence(cur);
                    nSeq.addWord(str);
                    if(nSeq.length == number.length()) {
                        if(seq == null || seq.sequence.size() > nSeq.sequence.size()) {
                            seq = nSeq;
                        }
                    } else {
                        queue.add(nSeq);
                    }
                }
            }
        }

        if(seq == null) {
            return null;
        }
        return seq.sequence;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = in.readLine();
            if(input.equals("-1")) {
                break;
            }

            String number = input;
            int count = Integer.valueOf(in.readLine());
            String[] words = new String[count];
            for(int i = 0; i < count; ++i) {
                words[i] = in.readLine();
            }

            List<String> seq = getWordSequence(number, words);

            if(seq != null) {
                ListIterator<String> it = seq.listIterator();
                while (it.hasNext()) {
                    String word = it.next();
                    System.out.print(word);
                    if(it.hasNext()) {
                        System.out.print(' ');
                    } else {
                        System.out.println();
                    }
                }
            } else {
                System.out.println("No solution.");
            }
        }
    }

    private static class WordSequence {
        public WordSequence() {
            sequence = new LinkedList<String>();
        }

        public WordSequence(String word) {
            sequence = new LinkedList<String>();
            addWord(word);
        }

        public WordSequence(WordSequence seq) {
            length = seq.length;
            sequence = new LinkedList<String>(seq.sequence);
        }

        public void addWord(String word) {
            sequence.add(word);
            length += word.length();
        }

        public int length = 0;
        public List<String> sequence;
    }
}

