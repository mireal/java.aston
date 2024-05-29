package exercises.sixth.niostream;

import java.nio.ByteBuffer;

public class ByteArrayOutputStreamRunner {
    public static void main(String[] args) {
        String text = "Hello Wolrd!";
        try {
            ByteBuffer byteBuffer = ByteBuffer.wrap(text.getBytes());

            System.out.println(new String(byteBuffer.array()));

            for (byte b : byteBuffer.array()) {
                System.out.print((char) b);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
