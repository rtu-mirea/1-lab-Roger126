package Laba2.ver2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TaskBack TaskName = new TaskBack();
        Scanner input = new Scanner(System.in);
        int enter;
        do {
            MainMenu();
            System.out.println("Input number task");
            enter = input.nextInt();
            switch (enter){
                case 1: {                  ///TaskOne
                    int enter1;
                    do {
                        System.out.println("Welcome to TaskOne");
                        MenuTaskOne();
                        enter1 = input.nextInt();
                        switch (enter1){
                            case 1: System.out.println(TaskName.TaskOneOne());
                                break;
                            case 2: System.out.println(TaskName.TaskOneTwo());
                                break;
                            case 3: System.out.println(TaskName.TaskOneThree());
                                break;
                            case 4: System.out.println(Arrays.toString(TaskName.TaskOneFour()));
                                break;
                        }

                    }while (enter1 !=0);
                }
                break;
                case 2: {                     ///TaskTwo
                    int enter2;
                    do {
                        System.out.println("Welcome to TaskTwo");
                        MenuTaskTwo();
                        enter2 = input.nextInt();
                        switch (enter2){
                            case 1: System.out.println(Arrays.toString(TaskName.TaskTwoOne()));
                                break;
                            case 2: System.out.println(TaskName.TaskTwoTwo());
                                break;
                            case 3: System.out.println(TaskName.TaskTwoThree());
                                break;
                        }

                    }while (enter2 !=0);

                }
                break;
                case 3: {                     ///TaskThree
                    System.out.println("Welcome to TaskThree");
                    int enter3;
                    do {
                        MenuTaskThree();
                        enter3 = input.nextInt();
                        switch (enter3){
                            case 1: System.out.println(TaskName.TaskThreeOne());
                                break;
                        }

                    }while (enter3 !=0);
                }
                break;
            }
        }while (enter != 0);

    }


    ///МНОГО РАЗНЫХ МЕНЮШЕК
    public static void MainMenu(){
        System.out.println("Welcome to my LabaTwo");
        System.out.println("0. Quit");
        System.out.println("1. TaskOne");
        System.out.println("2. TaskTwo");
        System.out.println("3. TaskThree");
    }

    public static void MenuTaskOne(){
        System.out.println("0. Back");
        System.out.println("1. Сменить Фамилию на прописные");
        System.out.println("2. Сформиновать массив по поставщикам");
        System.out.println("3. К домену com относится?");
        System.out.println("4. Массив фамилий по первой букве");
    }

    public static void MenuTaskTwo(){
        System.out.println("0. Back");
        System.out.println("1. Добавить новый контакт в текст");
        System.out.println("2. Найти адреса в которых опущено имя домена и /n заменить их на правльное");
        System.out.println("3. Количество контактов = число");
    }

    public static void MenuTaskThree(){
        System.out.println("0. Back");
        System.out.println("1. Вытянуть цену из строки");
    }


}
