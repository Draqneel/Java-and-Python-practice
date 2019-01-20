package ru.ivmiit;

import java.io.*;

public class FileWriterReaderExample {

    public static void main(String[] args) throws IOException {
        // create abstract struct in default NOT exist, NOT file, NOT directory.
        File file = new File("temp.txt");

        // if file with name "temp.txt" does not exist - create it ang sout log message
        if(!file.isFile()){
            file.createNewFile();
            System.out.println("LOG: File 'temp.txt' was created in src directory");
        }

        // create new directory with "temp.txt" name
        //  file.mkdir();

        // create object wich can which can write in file
        // append false (in default) - clear file before writing
        // append add - writing add new data in the end of file
        FileWriter writer = new FileWriter(file,false);
        // prepare data for writing
        writer.write("string 1\n");
        writer.write("string 2\n");
        // write in file
        writer.flush();
        // close file for reading and writing and save changes
        writer.close();

        // create object wich can which can read from file
        FileReader reader = new FileReader(file);
        // reading data from file (byte) add in char array and sout
        char[] chars = new char[(int) file.length()];
        for (int i = 0; i < file.length(); i++) {
            chars[i] = (char) reader.read();
            System.out.print(chars[i]);
        //  if we need only sout:
        //  System.out.println((char)reader.read());
        }
    }
}
