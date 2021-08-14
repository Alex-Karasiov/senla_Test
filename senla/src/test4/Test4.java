package test4;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Пожалуйста, введите число!");
            while (!sc.hasNextInt()) {
                System.out.println("Это не число!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);
        System.out.println("OK " + number);


        System.out.println("Разложение числа на множители ");
        int ces =number;
        int div =2;
        while (ces > 1)
        {
            while (ces % div == 0)
            {
                System.out.println(" * " + div);
                ces = ces / div;
            }
            if (div == 2) div++;
            else div += 2;
        }

    }
}