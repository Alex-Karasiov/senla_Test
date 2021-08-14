package test5;

import java.util.Arrays;
import java.util.Scanner;


public class Test5 {
    private static String outStr;

    public static void main(String[] args){
        System.out.println("Введите строку (ЕN):");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toLowerCase();

        for(int i=0; i< (str.length());i++){
            if(str.charAt(i)==' ') {
                outStr = outStr.substring(0, i + 1) + str.substring(i + 1, i + 2).toUpperCase() + str.substring(i + 2);
            }
            else if(i==0)
            {
                outStr=str.substring(0,1).toUpperCase()+str.substring(1);
                 }
        }
        System.out.println("Первая буква каждого слова изменена на заглавную");
        System.out.println(outStr);

        String[] words = str.split(" "); // делим и в массив
        for (int i = 0; i < words.length; i++) {

        }
        System.out.println();

        //количество гласных в каждом слове

         String vowel = "aeiouy"; // строка из гласных
         int[] count = new int[words.length];
         for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int index = vowel.indexOf(words[i].charAt(j));
                if (index > 0) {
                    count[i] = count[i] + 1;
                }
            }
        }

        System.out.println("колмчество глассных в словах:");
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }

        //Сортировка

        for (int i = 0; i < count.length - 1; i++) {

            for (int j = i+1; j < count.length; j++) {

                if (count[i] < count[j]) {

                    int buf = count[i];
                    count[i] = count[j];
                    count[j] = buf;

                    String sbuf = words[i]; //сортируем слова как count
                    words[i] = words[j];
                    words[j] = sbuf;
                }
            }
        }

        System.out.println();
        System.out.println("отсортированы числа и слова:");
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(words));

    }
}
