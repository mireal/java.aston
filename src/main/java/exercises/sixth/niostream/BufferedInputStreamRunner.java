package exercises.sixth.niostream;

import java.nio.ByteBuffer;

public class BufferedInputStreamRunner {
    public static void main(String[] args) {
        String text = "Hello world!";
        byte[] bytes = text.getBytes();

        try {
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
