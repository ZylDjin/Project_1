package Cryptoanaliz;

import Cryptoanaliz.file.FileHand;
import Cryptoanaliz.valid.Validator;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Application {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите режим работы: ");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифрование текста");
            System.out.println("3. Выход");
            int choise = scan.nextInt();
            scan.nextLine();

            switch (choise) {
                case 1:
                    System.out.println("Введите путь к файлу: ");
                    String inputFileEn = scan.nextLine();
                    System.out.println("Введите путь к файлу для зашифрованного текста: ");
                    String outputFileEn = scan.nextLine();
                    System.out.println("Введите ключ для сдвига: ");
                    int keyEncrypt = scan.nextInt();

                    if (!Validator.fileExists(inputFileEn)) {
                        System.out.println("Файл не существует");
                        break;
                    }
                    if (!Validator.isKeyValid(keyEncrypt)) {
                        System.out.println("Ключ должен быть от 0 до 31");
                        break;
                    }

                    try {
                        FileHand.processFile(inputFileEn, outputFileEn, keyEncrypt, true);
                        System.out.println("Текст зашифрован и записан в " + outputFileEn);
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Введите путь к файлу с зашифрованным текстом: ");
                    String inputFileDec = scan.nextLine();
                    System.out.println("Введите путь к файлу для расшифровки текста: ");
                    String outputFileDec = scan.nextLine();
                    System.out.println("Введите ключ (сдвиг):");
                    int keyDecrypt = scan.nextInt();

                    if (!Validator.fileExists(inputFileDec)) {
                        System.out.println("Файл не существует.");
                        break;
                    }

                    if (!Validator.isKeyValid(keyDecrypt)) {
                        System.out.println("Ключ должен быть от 0 до 31");
                        break;
                    }

                    try {
                        FileHand.processFile(inputFileDec, outputFileDec, keyDecrypt, false);
                        System.out.println("Текст успешно расшифрован и записан в " + outputFileDec);
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при обработке файлов: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Выход из программы");
                    scan.close();
                    return;

                default:
                    System.out.println("Неверный выбор, повторите попытку");
            }
        }
    }
}