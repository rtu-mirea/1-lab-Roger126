package Laba1;

import java.util.Scanner;

public class TaskBack {


    public static void InputArr(int size, int arr[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Keyboard(1) or Random(2)?");                  ///Создание выбора развития событий

        int way = input.nextInt();

        switch (way){

            case 1:

            {

                System.out.println("Insert array elements:");                ///Создание ручного ввода

                for(int i = 0; i < size; i++){

                    arr[i] = input.nextInt();

                }

                break;

            }

            case 2:

            {

                for (int i = 0; i < size; i++){

                    arr[i] = (0 + (int)(Math.random() * 20));                   ///Создание автоматического ввода

                }

                break;

            }

        }

    }



    public static void OutputArr(int size, int arr[]){                                           ///Вывод массива

        Scanner input = new Scanner(System.in);

        System.out.println("LeftRight(1) or RightLeft(2)?");

        int way2 = input.nextInt();

        switch (way2){

            case 1:{

                for(int i=0; i < size; i++) {

                    System.out.println(arr[i]);

                }

                break;

            }

            case 2:{

                for(int i=size-1; i > -1; i--) {

                    System.out.println(arr[i]);

                }

                break;

            }

        }

    }



    public static void TaskOne(int size, int arr[]){              /// Задание 1(Определить кол-во элементов массива

        int amount = 0;                                           /// у которых сумма цифр больше заданного значения)

        Scanner input = new Scanner(System.in);

        System.out.println("Input number");

        int number = input.nextInt();

        for(int i = 0; i < size; i++) {

            int mod = arr[i]%10;

            int div = arr[i]/10;

            if (mod + div > number)

                amount++;



        }

        System.out.println("Amount the number = "+ amount);



    }



    public static void TaskTwo(int size, int arr[]){              ///Задание 2(Сформировать новый массив из чисел исходного,

        int num =0;                                               /// У которых послядняя цифра больше первой

        int[] arr2;

        arr2 = new int[size];

        for(int i = 0; i < size; i++){

            int mod = arr[i]%10;

            int div = arr[i]/10;

            if(mod > div)

                arr2[i] = arr[i];

        }

        for(int i = 0; i < arr2.length; i++){

            if(arr2[i] != 0){

                num++;

                System.out.println("Number No."+ (num)+ " TaskTwo is " + arr2[i]);

            }

        }

    }

}
