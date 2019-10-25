package Laba2.ver2;
import java.lang.reflect.Array;
import java.util.Scanner;
import  java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskBack {

    private String[] data;

    TaskBack(){            ///Тута есть конструктор       ///Создание массива
        Scanner input = new Scanner(System.in);
        System.out.println("Input size contact list");
        int size = input.nextInt();
        data = new String[size];
        System.out.println("Input data about contacts");
        System.out.println("Example 1: Иванов И.И.,xxxxx@gmail.com.");
        System.out.println("Example 2(For providers): Иванов И.И.,xxxxx@gmail.com.,Наименование груза.,Цена: ххх.rub.");
        System.out.println("You can using gmail.com or mail.ru");
        System.out.println("You can using rub, ₽, r");
        input.nextLine();
        for (int i = 0; i < size; i++){
            System.out.print("No." + ( i + 1 ) + " is ");
                data[i] = input.nextLine();
        }
       /*for (String el : data){
            System.out.println("(" + el + ")");
        }*/
    }

    public void TaskOneOne(){ ///Задание с преобразованием строки
        for (int i = 0; i < data.length; i++){
            String str = new String();
            int index = data[i].indexOf(",");
            int lastindex = data[i].lastIndexOf(".");
            str = data[i].substring(0, index);
            str = str.toUpperCase();
            str += data[i].substring(index, lastindex + 1);
            System.out.println(str);
        }
    }
    public void TaskOneTwo(){ ///Разделить список по поставщику услуг с помощью пробелов
        Scanner input = new Scanner(System.in);
        String providers =new String();
        String contacts = new String();
        System.out.println("Input provider");
            providers = input.nextLine();
        for (int i = 0; i < data.length; i++){
            int index = data[i].indexOf("Наименование груза:");
            System.out.println(index);
            if (data[i].regionMatches(true, index + 19, providers, 0 , providers.length()))
                contacts += data[i];
                contacts += " ";
        }
        System.out.println(contacts);
    }
    public void TaskOneThree(){ ///Колличество доменов сom в контактах
        String domain = new String("com");
        int amount = 0;
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf("gmail.");
            if(data[i].regionMatches(index + 6, domain, 0, domain.length()))
                amount++;

        }
        System.out.println("Domain(com) have: " + amount + " contacts");
    }
    public void TaskOneFour(){ ///Составление нового списка контактов по первой букве фамилии
        Scanner input = new Scanner(System.in);
        String LastName = new String();
        String[] NameList = new String[data.length];
        System.out.println("Input first letter LastName");
        LastName = input.next();
        for (int i = 0; i < data.length; i++){
            int index = data[i].indexOf(",");
            if(data[i].regionMatches(true, 0,LastName,0,1))
                NameList[i] = data[i].substring(0, index);
        }
        System.out.println();
        for (int i = 0; i < NameList.length; i++){
                System.out.println(NameList[i]);
        }
    }
    public void TaskTwoOne(){ ///Добавление элемента в список
        Scanner input = new Scanner(System.in);
        System.out.println("Input amount new elements");
        int amount = input.nextInt();
        String NewData[] = Arrays.copyOf(data, data.length + amount);
        input.nextLine();
        for (int i = data.length; i < NewData.length; i++){
            System.out.print("No." + ( i + 1 ) + " is ");
            NewData[i] = input.nextLine();
        }
        /*for (String el : NewData){
            System.out.println("(" + el + ")");
        }*/
    }
    public void TaskTwoTwo(){ ///Вставка правильного домена, если сам домен не написан
        String domain = new String("com.");
        String domain1 = new String("ru.");
        String post = new String("gmail");
        String post1 = new String("@mail");
        for (int i = 0; i < data.length; i++){
            String halfstart = new String();
            String halfend = new String();
            int index = data[i].indexOf("mail");
            int lastindex = data[i].lastIndexOf(".");
            if (data[i].regionMatches(index-1, post, 0, 5)) {
                if (!data[i].regionMatches(index + 5, domain, 0, 4)) {
                    halfstart += data[i].substring(0, index + 5);
                    halfend += data[i].substring(index + 5, lastindex + 1);
                    halfstart += domain;
                    data[i] = halfstart;
                    data[i] = data[i].concat(halfend);
                    System.out.println(data[i]);
                    halfstart = halfstart.replaceAll(halfstart, "");
                    halfend = halfend.replaceAll(halfend, "");
                }
            }
            if (data[i].regionMatches(index-1, post1, 0, 5)) {
                if (!data[i].regionMatches(index + 5, domain1, 0, 3)) {
                    halfstart += data[i].substring(0, index + 5);
                    halfend += data[i].substring(index + 5, lastindex + 1);
                    halfstart += domain1;
                    data[i] = halfstart;
                    data[i] = data[i].concat(halfend);
                    System.out.println(data[i]);
                    halfstart = halfstart.replaceAll(halfstart, "");
                    halfend = halfend.replaceAll(halfend, "");
                }
            }

        }

    }
    public void TaskTwoThree(){ ///Кол-во контактов
        System.out.println("Your contact list have: " + data.length + " contacts");
    }
    ///Да, А вот и регулярочки
    public void TaskThreeOne(){  ///Ловля цен
        Scanner input = new Scanner(System.in);
        Pattern contact = Pattern.compile("[1-9][0-9]\\d*[.](rub|r|₽)[.]");
        for(int i = 0; i < data.length; i++){
           System.out.println("Contact No."+ (i+1) +" " + data[i]);
        }
        System.out.println("Input number of contact");
        int number = input.nextInt();  ///data[i-1];
        Matcher search = contact.matcher(data[number-1]);
        if(search.find())
            System.out.println(data[number-1].substring(search.start(), search.end()));
        else;
            System.out.println("price not find");

    }
}
