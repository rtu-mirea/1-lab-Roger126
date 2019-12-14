package Laba2.ver2;

import java.lang.reflect.Array;
import java.util.Scanner;
import  java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskBack {

    private String[] data;
    private String text;

    TaskBack() {            ///Тута есть конструктор       ///Создание массива
        Scanner input = new Scanner(System.in);
        System.out.println("Input size contact list");
        int size = input.nextInt();
        data = new String[size];
        System.out.println("Input data about contacts");
        System.out.println("Example 1: Иванов_И.И.,xxxxx@gmail.com.");
        System.out.println("Example 2(For providers): Иванов_И.И.,xxxxx@gmail.com.,Услуга:.,Цена:_ххх.rub.");
        System.out.println("You can using gmail.com or mail.ru");
        System.out.println("You can using rub, ₽, r");
        input.nextLine();
        text = input.nextLine();
        int i = 0;
        for (String splittext : text.split(" ")) {
            if (i != size) {
                data[i] = splittext;
                i++;
            }
        }
       /*for (String el : data){
            System.out.println("(" + el + ")");
        }*/
    }

    public String TaskOneOne() { ///Задание с преобразованием строки
        String str = new String();
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf(",");
            int lastindex = data[i].lastIndexOf(".");
            str = data[i].substring(0, index);
            str = str.toUpperCase();
            str += data[i].substring(index, lastindex + 1);
            //System.out.println(str);
        }
        return str;
    }

    public String TaskOneTwo() { ///Разделить список по поставщику услуг с помощью пробелов
        Scanner input = new Scanner(System.in);
        String providers = new String();
        String contacts = new String();
        System.out.println("Input provider");
        providers = input.nextLine();
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf("Услуга:");
            System.out.println(index);
            if (data[i].regionMatches(true, index + 7, providers, 0, providers.length()))
                contacts += data[i];
            contacts += " ";
        }
      //  System.out.println("Amount contacts: " + TaskTwoThree());
       // System.out.println(contacts);
        return contacts;
    }

    public int TaskOneThree() { ///Колличество доменов сom в контактах(Я не понял, как сделать с помощью обычного сплошного текста)
        String domain = new String("com"); //Извините
        int amount = 0;
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf("gmail.");
            if (data[i].regionMatches(index + 6, domain, 0, domain.length()))
                amount++;

        }
        //System.out.println("Domain(com) have: " + amount + " contacts");
        return amount;
    }

    public String[] TaskOneFour() { ///Составление нового списка контактов по первой букве фамилии
        Scanner input = new Scanner(System.in);
        String LastName = new String();
        String[] NameList = new String[data.length];
        System.out.println("Input first letter LastName");
        LastName = input.next();
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf(",");
            if (data[i].regionMatches(true, 0, LastName, 0, 1))
                NameList[i] = data[i].substring(0, index);
        }
        //System.out.println();
        //for (int i = 0; i < NameList.length; i++) {
        //    System.out.println(NameList[i]);
        //}
        return NameList;
    }

    public String[] TaskTwoOne() { ///Добавление элемента в список с помощью StringBuilder
        Scanner input = new Scanner(System.in);
        StringBuilder addcontacts = new StringBuilder(text);
        addcontacts.append(" ");
        System.out.println("How much contacts you want add?");
        int amount = input.nextInt();
        System.out.println("Example 1: Иванов_И.И.,xxxxx@gmail.com.");
        System.out.println("Example 2(For providers): Иванов_И.И.,xxxxx@gmail.com.,Услуга:.,Цена:_ххх.rub.");
        System.out.println("You can using gmail.com or mail.ru");
        System.out.println("You can using rub, ₽, r");
        System.out.println("Input NEW data about contacts");
        input.nextLine();
        addcontacts = addcontacts.append(input.nextLine());
        text = new String(addcontacts);
        data = new String[data.length + amount];
        int i = 0;
        for (String splittext : text.split(" ")) {
            if (i != data.length) {
                data[i] = splittext;
                i++;
            }
        }
        return data;
        /*for (String el : data) {
            System.out.println(el);
        }*/
    }

    public String[] TaskTwoTwo() { ///Вставка правильного домена, если сам домен не написан
        String domain = new String("com.");
        String domain1 = new String("ru.");
        String post = new String("gmail");
        String post1 = new String("@mail");
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf("mail");
            int lastindex = data[i].lastIndexOf(".");
            if (data[i].regionMatches(index - 1, post, 0, 5)) {
                if (!data[i].regionMatches(index + 5, domain, 0, 4)) {
                    StringBuilder com = new StringBuilder(data[i]);
                    com.insert(index + 5, domain);
                    String Storage1 = new String(com);
                    data[i] = Storage1;
                }
            }
            if (data[i].regionMatches(index - 1, post1, 0, 5)) {
                if (!data[i].regionMatches(index + 5, domain1, 0, 3)) {
                    StringBuilder com = new StringBuilder(data[i]);
                    com.insert(index + 5, domain1);
                    String Storage2 = new String(com);
                    data[i] = Storage2;
                }
            }

        }
        return data;
        //for (String el : data) {
          //  System.out.println(el);
        //}
    }

    public int TaskTwoThree() { ///Кол-во контактов
        System.out.println("Your contact list have: " + data.length + " contacts");
        return data.length;
    }

    ///Да, А вот и регулярочки
    public String TaskThreeOne() {  ///Ловля цен
        Scanner input = new Scanner(System.in);
        Pattern contact = Pattern.compile("[1-9][0-9]\\d*[.](rub|r|₽)[.]");
        for (int i = 0; i < data.length; i++) {
            System.out.println("Contact No." + (i + 1) + " " + data[i]);
        }
        System.out.println("Input number of contact");
        int number = input.nextInt();  ///data[i-1];
        Matcher search = contact.matcher(data[number - 1]);
        if (search.find()) {
            return data[number - 1].substring(search.start(), search.end());
        } else {
            return "None";
        }

    }
}

