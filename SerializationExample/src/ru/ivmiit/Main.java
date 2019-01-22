package ru.ivmiit;

import ru.ivmiit.models.Human;
import ru.ivmiit.models.Man;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 *  "Serialization is the process of translating data structures or object state
 *  into a format that can be stored.
 *  When the resulting series of bits is reread according to the serialization format,
 *  it can be used to create a semantically identical clone of the original object." (c) Wiki
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Man manOne = new Man(38, "Oleg");
        Man manTwo = new Man(12, "Petya");
        Man manThree = new Man(19, "Seva");

        List<Human> humanList = new LinkedList<>();

        humanList.add(manOne);
        humanList.add(manTwo);
        humanList.add(manThree);

        // create object which can serialize java objects into bits series
        // (object and id children must implements Serializable or Externalizable (wrapper))
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("text.txt"));
        // add objects in queue for writing
        for (Human human : humanList) {
            outputStream.writeObject(human);
        }
        // write into file
        outputStream.flush();
        // close file for writing
        outputStream.close();

        // create object which can create java objects on basics bits series
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("text.txt"));
        for (int i = 0; i < humanList.size(); i++) {
            // sout on display
            System.out.println(inputStream.readObject().toString());
        }
    }
}
