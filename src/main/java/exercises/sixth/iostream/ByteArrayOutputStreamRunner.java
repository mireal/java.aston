package exercises.sixth.iostream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamRunner {

    public static void main(String[] args) {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            String text = "Hello Wolrd!";
            byte[] buffer = text.getBytes();
            baos.write(buffer);
            // превращаем массив байтов в строку
            System.out.println(baos);

            // получаем массив байтов и выводим по символьно
            byte[] array = baos.toByteArray();
            for (byte b : array) {
                System.out.print((char) b);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
