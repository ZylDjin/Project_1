package Cryptoanaliz.caesar;

public class CaesarChipher {
    private static final char[] RU_ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я'
    };
    private static final char[] SYMBOLS = {
            '1','2','3','4','5','6','7','8','9','0',
            ' ',',','.','\'','|',':',';','*','(',')',
            '<','>','@','#','$','%','&','?'
    };

    public static String encrypt (String text, int transfer) {
        transfer = transfer % 32 + 32;
        StringBuilder encrypted = new StringBuilder();
        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encrypted.append((char) ('A' + (i - 'A' + transfer) % 32));
                } else {
                    encrypted.append((char) ('a' + (i - 'a' + transfer) % 32));
                }
            } else {
                encrypted.append(i);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt (String text, int transfer) {
        return encrypt(text, -transfer);
    }

}
