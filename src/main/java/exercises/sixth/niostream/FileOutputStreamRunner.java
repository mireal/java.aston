package exercises.sixth.niostream;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOutputStreamRunner {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/resources/text2.txt");

        try (FileChannel channel = FileChannel.open(path,StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            String value = "Hello World2!";
            int _ = channel.write(ByteBuffer.wrap(value.getBytes()));
            int _ = channel.write(ByteBuffer.wrap(System.lineSeparator().getBytes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
