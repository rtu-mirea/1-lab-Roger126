package laba4;

import java.io.*;

public class Human implements Serializable {// класс для задания 4

    String Name;
    String Surname;
    int Age;

    public Human(String name, String surname, int age) {
        Name = name;
        Surname = surname;
        Age = age;

    }

}