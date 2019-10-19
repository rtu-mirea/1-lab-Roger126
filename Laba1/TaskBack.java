package Laba1;

import java.util.Scanner;

public class TaskBack {

    private  int[] arr;

    TaskBack(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input size the massive");

        int size = input.nextInt();                        ///Создание массива

        arr = new int[size];

    }

    public void InputArr(){
        Scanner input = new Scanner(System.in);
        System.out.println("Keyboard(1) or Random(2)?");                  ///Создание выбора развития событий
        int way = input.nextInt();
        switch (way){
            case 1:
            {
                System.out.println("Insert array elements:");                ///Создание ручного ввода
                for(int i = 0; i < arr.length; i++){
                    arr[i] = input.nextInt();
                }
                break;
            }
            case 2:
            {
                for (int i = 0; i < arr.length; i++){
                    arr[i] = (0 + (int)(Math.random() * 20));                   ///Создание автоматического ввода
                }
                break;
            }
        }
    }

    public void OutputArr(){                                           ///Вывод массива
        Scanner input = new Scanner(System.in);
        System.out.println("LeftRight(1) or RightLeft(2)?");
        int way2 = input.nextInt();
        switch (way2){
            case 1:{
                for(int i=0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
                break;
            }
            case 2:{
                for(int i=arr.length-1; i > -1; i--) {
                    System.out.println(arr[i]);
                }
                break;
            }
        }
    }

    public void TaskOne(){              /// Задание 1(Определить кол-во элементов массива
        int amount = 0;                                 /// у которых сумма цифр больше заданного значения)
        Scanner input = new Scanner(System.in);
        System.out.println("Input number");
        int number = input.nextInt();
        for(int i = 0; i < arr.length; i++) {
            int mod = arr[i]%10;
            int div = arr[i]/10;
            if (mod + div > number)
                amount++;
        }
        System.out.println("Amount the number = "+ amount);



    }

    public void TaskTwo(){              ///Задание 2(Сформировать новый массив из чисел исходного,
        int num =0;                                     /// У которых послядняя цифра больше первой
        int[] arr2;
        arr2 = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
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
