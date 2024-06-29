package Cryptoanaliz.caesar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarChipher {

    private static final List<Character> RU_ALPHABET_LOWER = Arrays.asList(
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я'
    );

    private static final List<Character> RU_ALPHABET_UPPER = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю', 'Я'
    );

    private static final List<Character> SYMBOLS = Arrays.asList(
            '1','2','3','4','5','6','7','8','9','0',
            ' ',',','.','\'','|',':',';','*','(',')',
            '<','>','@','#','$','%','&','?'
    );

    private static final List<Character> ALPHABET_ALL = createFullAlphabet();
    private static final int ALPHABET_SIZE = ALPHABET_ALL.size();

    private static List<Character> createFullAlphabet() {
        List<Character> fullAlphabet = new ArrayList<>();
        fullAlphabet.addAll(RU_ALPHABET_UPPER);
        fullAlphabet.addAll(RU_ALPHABET_LOWER);
        fullAlphabet.addAll(SYMBOLS);
        return fullAlphabet;
    }

    public static String encrypt(String text, int transfer) {
        transfer = (transfer % ALPHABET_SIZE + ALPHABET_SIZE) % ALPHABET_SIZE;
        StringBuilder encrypted = new StringBuilder();

        for (char character : text.toCharArray()) {
            int onePosition = ALPHABET_ALL.indexOf(character);
            if (onePosition != -1) {
                int newPosition = (onePosition + transfer) % ALPHABET_SIZE;
                encrypted.append(ALPHABET_ALL.get(newPosition));
            } else {
                encrypted.append(character);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt (String text, int transfer) {
        return encrypt(text, -transfer);
    }

}
