package Laba1;

import java.util.Scanner;

public class Main {
    public void main(String[] args) {             ///Консольное приложение

        /* Поле для задания */

        TaskBack TaskName = new TaskBack();
        Scanner input = new Scanner(System.in);
        int inter;
        do {
            PrintMenu();
            System.out.println("Input number operation");
            inter = input.nextInt();
            switch (inter) {
                case 1: TaskName.InputArr();
                    break;
                case 2: TaskName.OutputArr();
                    break;
                case 3: TaskName.TaskOne();
                    break;
                case 4: TaskName.TaskTwo();
                    break;
            }
        }while(inter != 0);
    }

    public  void PrintMenu(){
        System.out.println("0. Quit");
        System.out.println("1. Input Massive");
        System.out.println("2. Output Massive");
        System.out.println("3. TaskOne");
        System.out.println("4. TaskTwo");
    }
}
