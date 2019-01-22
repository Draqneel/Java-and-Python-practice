package ru.ivmiit;

import ru.ivmiit.models.Human;
import ru.ivmiit.models.Man;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Man manOne = new Man(38, "Oleg");
        Man manTwo = new Man(12, "Petya");
        Man manThree = new Man(19, "Seva");

        List<Human> humanList = new LinkedList<>();

        humanList.add(manOne);
        humanList.add(manTwo);
        humanList.add(manThree);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("text.txt"));
        for (Human human : humanList) {
            outputStream.writeObject(human);
        }
        outputStream.flush();
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("text.txt"));
        for (int i = 0; i < humanList.size(); i++) {
            System.out.println(inputStream.readObject().toString());
        }
    }
}
