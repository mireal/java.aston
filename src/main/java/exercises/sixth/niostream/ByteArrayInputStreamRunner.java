package exercises.sixth.niostream;

import java.nio.ByteBuffer;

public class ByteArrayInputStreamRunner {
    public static void main(String[] args) {

        readAllBytes();

        readFiveChars();
    }

    private static void readAllBytes() {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteBuffer byteStream1 = ByteBuffer.wrap(array1);
        while (byteStream1.hasRemaining()) {
            System.out.println(byteStream1.get());
        }
    }

    private static void readFiveChars() {
        String text = "Hello world!";
        byte[] array2 = text.getBytes();
        // считываем 5 символов
        ByteBuffer byteStream2 = ByteBuffer.wrap(array2,0,5);
        while (byteStream2.hasRemaining()) {
            System.out.println((char) byteStream2.get());
        }
    }
}
