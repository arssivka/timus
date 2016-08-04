import java.util.Scanner;

public class Main {
    public static final TranslationUnit[] TRANSLATION_TABLE = new TranslationUnit[] {
            new TranslationUnit(5,                  "few"),
            new TranslationUnit(10,                 "several"),
            new TranslationUnit(20,                 "pack"),
            new TranslationUnit(50,                 "lots"),
            new TranslationUnit(100,                "horde"),
            new TranslationUnit(250,                "throng"),
            new TranslationUnit(500,                "swarm"),
            new TranslationUnit(1000,               "zounds"),
            new TranslationUnit(Integer.MAX_VALUE,  "legion")
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();

        for(TranslationUnit unit : TRANSLATION_TABLE) {
            if(count < unit.getBorder()) {
                System.out.println(unit);
                break;
            }
        }
    }

    public static class TranslationUnit {
        private int mBorder;
        private String mTranslation;

        public TranslationUnit(int border, String translation) {
            mBorder = border;
            mTranslation = translation;
        }

        public String toString() {
            return mTranslation;
        }

        public int getBorder() {
            return mBorder;
        }
    }
}
