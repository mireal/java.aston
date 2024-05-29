package exercises.sixth.niostream;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedOutputStreamRunner {
    public static void main(String[] args) {
        String pathStr = "./src/main/resources/text3.txt";
        String text = "Hello Java world!"; // строка для записи

        try (FileChannel channel = FileChannel.open(Paths.get(pathStr),StandardOpenOption.CREATE, StandardOpenOption.WRITE)){
            byte[] bytes = text.getBytes();
            if (channel.write(ByteBuffer.wrap(bytes)) == 0) {
                System.out.println("Nothing was written");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
