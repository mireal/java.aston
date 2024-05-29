package exercises.sixth.iostream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamRunner {
    public static void main(String[] args) {
        readEachByte();
        System.out.println("--------------------");
        readAllBytes();

    }

    private static void readAllBytes() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("./src/main/resources/text.txt");
            byte[] bytes = inputStream.readAllBytes();
            String stringValue = new String(bytes);
            System.out.println(stringValue);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private static void readEachByte() {
        try (FileInputStream inputStream = new FileInputStream("./src/main/resources/text.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) inputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String stringValue = new String(bytes);
            System.out.println(stringValue);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
