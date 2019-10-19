package Laba1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {             ///Консольное приложение

        /* Поле для задания */

        TaskBack TaskName = new TaskBack();
        Scanner input = new Scanner(System.in);
        System.out.println("Input size the massive");

        int size = input.nextInt();                        ///Создание массива

        int[] arr;

        arr = new int[size];

        int inter;

        do {

            PrintMenu();

            System.out.println("Input number operation");

            inter = input.nextInt();

            switch (inter) {

                case 1: TaskName.InputArr(size, arr);



                    break;

                case 2: TaskName.OutputArr(size,arr);



                    break;

                case 3: TaskName.TaskOne(size,arr);



                    break;

                case 4: TaskName.TaskTwo(size,arr);



                    break;

            }



        }while(inter != 0);



    }

    public static void PrintMenu(){

        System.out.println("0. Quit");

        System.out.println("1. Input Massive");

        System.out.println("2. Output Massive");

        System.out.println("3. TaskOne");

        System.out.println("4. TaskTwo");

    }


}
