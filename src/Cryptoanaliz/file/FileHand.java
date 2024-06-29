package Cryptoanaliz.file;

import Cryptoanaliz.caesar.CaesarChipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHand {

    public static void processFile (String inputFilePath, String outputFilePath, int transfer, boolean isEncrypt) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {

        String line;
        while ((line = reader.readLine()) != null) {
            String processedLine;
            if (isEncrypt) {
                processedLine = CaesarChipher.encrypt(line, transfer);
            } else {
                processedLine = CaesarChipher.decrypt(line, transfer);
            }
            writer.write(processedLine);
            writer.newLine();
        }
    }
    }
}
