package ru.ivmiit;

import java.io.*;
import java.util.stream.Stream;

public class BufferReaderWriterExample {
    public static void main(String[] args) throws IOException {
        File file = new File("tempBuf.txt");
        if (!file.isFile()) {
            file.createNewFile();
            System.out.println("LOG: File 'temp.txt' was created in src directory");
        }
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file);

        // more convenient way to work with a file then FileWriter
        BufferedWriter bufWriter = new BufferedWriter(writer);
        bufWriter.write("string 1 with bufWriter");
        bufWriter.newLine();
        bufWriter.write("string 2 with bufWriter");
        bufWriter.flush();
        bufWriter.close();

        // more convenient way to work with a file then FileReader
        BufferedReader bufReader = new BufferedReader(reader);
        Stream<String> stream = bufReader.lines();
        stream.forEach(s -> System.out.println(s));
    }
}
