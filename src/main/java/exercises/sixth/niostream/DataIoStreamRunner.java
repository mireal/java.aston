package exercises.sixth.niostream;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DataIoStreamRunner {
    public static void main(String[] args) {

        Person tom = new Person("Tom", 34, 1.68, false);
        String path = "./src/main/resources/data.bin";
        // запись в файл
        writeDataToFile(path, tom);

        // обратное считывание из файла
        readDataFromFile(path);
    }

    private static void writeDataToFile(String pathStr, Person tom) {
        Path path = Paths.get(pathStr);
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE)){
            short len = (short) tom.name.length();
            ByteBuffer buffer = ByteBuffer.allocate(15 + len);

            buffer.putShort(len);
            buffer.put(StandardCharsets.UTF_8.encode(tom.name).array());
            buffer.putInt(tom.age);
            buffer.putDouble(tom.height);
            buffer.put((byte) (tom.married ? 1 : 0));

            buffer.flip();
            int size = channel.write(buffer);

            System.out.println("File has been written. " + size);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readDataFromFile(String pathStr) {
        Path path = Paths.get(pathStr);
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);
            buffer.flip();

            short len = buffer.getShort();
            byte[] byteStr = new byte[len];
            buffer.get(byteStr, 0, len);

            String name = new String(byteStr, StandardCharsets.UTF_8);
            int age = buffer.getInt();
            double height = buffer.getDouble();
            boolean married = buffer.get() == 1;

            System.out.printf("Name: %s  Age: %d  Height: %f  Married: %b", name, age, height, married);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Person {
    public String name;
    public int age;
    public double height;
    public boolean married;

    public Person(String n, int a, double h, boolean m) {
        this.name = n;
        this.height = h;
        this.age = a;
        this.married = m;
    }
}
