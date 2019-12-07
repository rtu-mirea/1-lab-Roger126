package laba4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

class Program {
    private static final String DIR1 = "C:\\LevelOne\\LevelTwo\\LevelThree";
    private static final String DIR2 = "C:\\Users\\ivanb\\IdeaProjects\\Laba4";
    private static final String DIR3 = "C:\\LevelOne";

    public static void main(String[] args) throws Exception {
        File F1 = new File("MyFile1.txt");
        try {
            F1.createNewFile();
            System.out.println("Папка " + F1.getName() + " создалась");
        } catch (IOException ex) {
            System.out.println("Папка " + F1.getName() + " не создалась");
        }
        if (F1.exists()) {
            System.out.println("Папка приложения содержит файл " + F1.getName());
            System.out.println("Полный путь к файлу MyFile1.txt " + F1.getAbsolutePath());
            if (F1.isFile()) {
                System.out.println(F1.getName() + " - это файл");
            } else {
                System.out.println(F1.getName() + " - это папка");
            }
            System.out.println("Размер " + F1.getName() + " - " + F1.length() + " Байт");
        }
        System.out.println("\n");
        File F2 = new File("C:\\MyFile2.txt");
        try {
            F2.createNewFile();
            System.out.println("Папка " + F2.getName() + " создалась");
        } catch (IOException ex) {
            System.out.println("Папка " + F2.getName() + " не создалась");
        }
        System.out.println("\n");
        File F3 = new File("C:\\Test\\MyFile3.txt");
        try {
            F3.createNewFile();
            System.out.println("Папка " + F3.getName() + " создалась");
        } catch (IOException ex) {
            System.out.println("Папка " + F3.getName() + " не создалась");
        }
        if (F3.exists()) {
            System.out.println("Папка содержит файл " + F3.getName());
            System.out.println("Полный путь к файлу MyFile3.txt " + F3.getAbsolutePath());
            if (F3.isFile()) {
                System.out.println(F3.getName() + " - это файл");
            } else {
                System.out.println(F3.getName() + " - это папка");
            }
            System.out.println("Размер " + F3.getName() + " - " + F3.length() + " Байт");
        }
        System.out.println("\n");
        final File dir1 = new File(DIR1);
        if (!dir1.exists()) {
            if (dir1.mkdirs()) {
                System.out.println("Kaтaлoг " + dir1.getAbsolutePath() + " ycпeшнo coздaн.");
            } else {
                System.out.println("Kaтaлoг " + dir1.getAbsolutePath() + " coздать нe yдaлocь.");
            }
        } else {
            System.out.println("Kaтaлoг " + dir1.getAbsolutePath() + " yжe cyщecтвyeт.");
        }
        if (dir1.exists()) {
            if (dir1.isDirectory())
                System.out.println("Каталог " + dir1.getAbsolutePath() + " - это каталог папок");
            System.out.println("Размер " + dir1.getAbsolutePath() + " - " + dir1.length() + " Байт");
        }
        System.out.println("\n");
        File F4 = new File("MyFile4.txt");
        F4.createNewFile();
        final File dir2 = new File(DIR2);
        System.out.println("Список файлов в папке приложения через метод listFiles");
        int i = 0;
        try {
            while (dir2.exists()) {
                System.out.println(dir2.listFiles()[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        System.out.println("\n");
        System.out.println("Список файлов в папке приложения через метод list");
        i = 0;
        try {
            while (dir2.exists()) {
                System.out.println(dir2.list()[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        System.out.println("Кол-во папок в папке приложения: " + i);
        if (F1.delete()) {
            System.out.println("Файл " + F1.getName() + " удален");
        }
        if (F2.delete()) {
            System.out.println("Файл " + F2.getName() + " удален");
        }
        if (F3.delete()) {
            System.out.println("Файл " + F3.getName() + " удален");
        }
        if (F4.delete()) {
            System.out.println("Файл " + F4.getName() + " удален");
        }
        new Program().delete(new File(DIR3));

        // упражнение 2
        System.out.print("Введите название файла ");
        Scanner in = new Scanner(System.in);
        String name = in.next();

        fil f = new fil(name);
        UniversityStaff b1 = new UniversityStaff("Annenkov","Alexander", "Moscow", "Male", "2000", 2, 3131);
        f.add3(b1);
        UniversityStaff b2 = new UniversityStaff("Chaykina","Alyona", "Novosib", "Female", "2002", 1, 4221);
        f.add3(b2);
        System.out.println(f.get1());
// Упражнение 3
        t3 t = new t3();
        File f1 = new File("aa.txt");
        File f2 = new File("b.txt");
        t.ex3(f1);
//Упражнение 4
        text4 ex4 = new text4("inf.txt");
        t4 tsk = new t4("hum.dat");
        tsk.addl(ex4.transcript());
        tsk.put();
        tsk.take();

    }

    private void delete(final File file) {
        System.out.println("Удaляem фaйл: " + file.getAbsolutePath());
        if (file.isDirectory()) {
            String[] files = file.list();
            if ((null == files) || (files.length == 0)) {
                file.delete();
            }
            else {
                for (final String filename : files) {
                  delete(new File(file.getAbsolutePath() + File.separator + filename));
                } file.delete();
            }
        }
        else {
        }
    }
}
