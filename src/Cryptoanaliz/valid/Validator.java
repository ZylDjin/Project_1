package Cryptoanaliz.valid;

import java.io.File;

public class Validator {

    public static boolean fileExists (String filePath) {
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }

    public static boolean isKeyValid (int key) {
        return key >= 0 && key < 32;
    }

}
