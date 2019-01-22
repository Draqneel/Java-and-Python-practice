package ru.ivmiit.models;

import java.io.Serializable;

public class Man extends Human implements Serializable {
    private int holeySocksCount;

    public Man(int age, String name, String phoneNumber, int holeySocksCount) {
        super(age, name, phoneNumber);
        this.holeySocksCount = holeySocksCount;
    }

    public Man(int age, String name) {
        this(age, name, "",0);
    }

    public int getHoleySocksCount() {
        return holeySocksCount;
    }

    public void setHoleySocksCount(int holeySocksCount) {
        this.holeySocksCount = holeySocksCount;
    }

    @Override
    public String toString() {
        return "Man{" + "age=" + super.getAge() +
                ", name='" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                "holeySocksCount=" + holeySocksCount +
                '}';
    }
}
