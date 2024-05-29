package exercises.sixth.niostream;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInputStreamRunner {
    public static void main(String[] args) {
        String path = "./src/main/resources/text.txt";
        readEachByte(path);
        System.out.println("--------------------");
        readAllBytes(path);

    }

    private static void readAllBytes(String pathStr) {
        try {
            Path path = Paths.get(pathStr);
            byte[] bytes = Files.readAllBytes(path);
            String stringValue = new String(bytes);
            System.out.println(stringValue);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readEachByte(String pathStr) {
        try (FileChannel channel = FileChannel.open(Paths.get(pathStr))) {
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);

            byte[] bytes = new byte[buffer.limit()];
            buffer.flip();

            for (int i = 0; i < buffer.limit(); i++) {
                bytes[i] = buffer.get();
            }

            String result = new String(bytes);
            System.out.println(result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
