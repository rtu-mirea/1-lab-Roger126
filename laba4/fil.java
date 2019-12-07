package laba4;

import java.io.RandomAccessFile;
import java.io.*;
import java.util.Arrays;


public class fil {
    File file;
    int size;

    public fil(String name) throws IOException, Exception, FileNotFoundException {
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add(UniversityStaff bok) throws IOException, Exception, FileNotFoundException {//Перезапись
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(), true))) {
            // записываем значения
            dos.writeUTF(bok.Surname);
            dos.writeUTF(bok.Name);
            dos.writeUTF(bok.Address);
            dos.writeUTF(bok.Birthday);
            dos.writeUTF(bok.Sex);
            dos.writeInt(bok.TabNumber);
            dos.writeInt(bok.AmountChildren);
            size = 1;
            dos.close();

        }

    }

    public void add2(UniversityStaff bok) throws IOException, Exception, FileNotFoundException {//Запись в конец
        try (FileOutputStream dos = new FileOutputStream(file.getPath(), true)) {
            // записываем значения
            dos.write(bok.Surname.getBytes());
            dos.write(bok.Name.getBytes());
            dos.write(bok.Address.getBytes());
            dos.write(bok.Birthday.getBytes());
            dos.write(bok.Sex.getBytes());
            dos.write(bok.TabNumber);
            dos.write(bok.AmountChildren);
            size++;
            dos.close();
        }

    }

    public String findbyMale(String Sex) throws IOException, Exception, FileNotFoundException { //Найти Мужчин
        try (DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath()))) {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int number = 0;
            int child = 0;
            String birth = "";
            String S = "";
            String sex = "";
            String sername = "";
            String name = "";
            String adress = "";
            while (i < size) {
                sername = dos.readUTF();
                name = dos.readUTF();
                adress = dos.readUTF();
                birth = dos.readUTF();
                number = dos.readInt();
                i++;
                if (Sex.equals(sex))
                    S += "Фамилия " + sername + " Имя " + name + " адрес " + adress + " табельный номер " + number + "дата рождения" + birth + "кол-во детей" + child + "\n";
            }

            return S;
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return null;
    }

    public void exchange(String Sername) throws IOException, Exception, FileNotFoundException {
        UniversityStaff[] mass = new UniversityStaff[size];
        try (DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath()))) { //Сделать 4 задание !!!!!!!!!!!

            int i = 0;
            int number = 0;
            int child = 0;
            String sex = "";
            String birth = "";
            String S = "";
            String sername = "";
            String name = "";
            String adress = "";
            size -= 1;
            UniversityStaff[] mass1 = new UniversityStaff[size];
            mass[0] = mass[mass.length - 1];
            mass1 = Arrays.copyOf(mass, mass.length - 1);
            mass = mass1;
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(), true))) {
            size = 0;
            // записываем значения
            dos.writeUTF(mass[0].Surname);
            dos.writeUTF(mass[0].Name);
            dos.writeUTF(mass[0].Address);
            dos.writeUTF(mass[0].Birthday);
            dos.writeUTF(mass[0].Sex);
            dos.writeInt(mass[0].TabNumber);
            dos.writeInt(mass[0].AmountChildren);
            size = 1;
            dos.close();

        }
        for (int i = 1; i < mass.length; i++) {
            try (FileOutputStream dos = new FileOutputStream(file.getPath(), true)) {
                // записываем значения
                dos.write(mass[i].Surname.getBytes());
                dos.write(mass[i].Name.getBytes());
                dos.write(mass[i].Address.getBytes());
                dos.write(mass[i].Birthday.getBytes());
                dos.write(mass[i].Sex.getBytes());
                dos.write(mass[i].TabNumber);
                dos.write(mass[i].AmountChildren);
                size++;
                dos.close();
            }
        }

    }


    public String get() throws IOException, Exception, FileNotFoundException { //распечатать файл
        try (DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath()))) {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int number = 0;
            int child = 0;
            String sex = "";
            String birth = "";
            String S = "";
            String sername = "";
            String name = "";
            String adress = "";
            while (i < size) {
                sername = dos.readUTF();
                name = dos.readUTF();
                sex = dos.readUTF();
                adress = dos.readUTF();
                birth = dos.readUTF();
                number = dos.readInt();
                child = dos.readInt();
                i++;
                S += "Фамилия " + sername + " Имя " + name + " адрес " + adress + " табельный номер " + number + "дата рождения" + birth + "кол-во детей" + child + "\n";
            }

            return S;
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return null;
    }


    public String get1() throws IOException {//вывести файл RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(0);
        String text1 = raf.readLine();
        raf.close();
        return text1;
    }

    public void add(int i, UniversityStaff smth) throws IOException {//вставить в определенное место файла RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(i * 42);
        String text1 = raf.readLine();
        raf.close();
        RandomAccessFile raf1 = new RandomAccessFile("file.txt", "rw");
        raf1.seek(i * 42);
        raf.writeBytes(("Surname: " + smth.Surname));
        raf.writeBytes(" Name: " + smth.Name);
        raf.writeBytes("Number ");
        raf.writeBytes(String.valueOf(smth.TabNumber));
        raf.writeBytes(" Date of birth ");
        raf.writeBytes(String.valueOf(smth.Birthday));
        raf.writeBytes(" Address " + smth.Address);
        raf.writeBytes(text1);


    }

    public void add3(UniversityStaff smth) throws IOException {//добавить в конец RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
        raf.seek(raf.length());
        raf.writeBytes(("Surname: " + smth.Surname));
        raf.writeBytes(" Name: " + smth.Name);
        raf.writeBytes("Number ");
        raf.writeBytes(String.valueOf(smth.TabNumber));
        raf.writeBytes(" Date of birth ");
        raf.writeBytes(String.valueOf(smth.Birthday));
        raf.writeBytes(" Address " + smth.Address);
        raf.close();

    }

}