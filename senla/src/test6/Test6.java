package test6;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test6 {

    static class Digit {
        String[] lines;

        public Digit(String... lines) {
            this.lines = lines;
        }

        public static Digit[] createDigits(String... lines) {
            int height = lines.length;
            int width = (lines[0].length() - 9 /* десять цифр => девять пробелов */) / 10;
            return IntStream
                    .range(0, 10)  // Stream из цифр 0-9
                    .mapToObj(digit ->
                            new Digit(Stream
                                    .of(lines)
                                    .map(line -> line.substring(digit * (width + 1), (digit + 1) * (width + 1) - 1))
                                    .toArray(String[]::new))
                    ).toArray(Digit[]::new);
        }
    }

    public static void main(String[] args) {
        Digit[] digits = Digit.createDigits(
                "  ###      #     #####   #####  #       #######  #####  #######  #####   ##### ",
                " #   #    ##    #     # #     # #    #  #       #     # #    #  #     # #     #",
                "#     #  # #          #       # #    #  #       #           #   #     # #     #",
                "#     #    #     #####   #####  #    #  ######  ######     #     #####   ######",
                "#     #    #    #             # #######       # #     #   #     #     #       #",
                " #   #     #    #       #     #      #  #     # #     #   #     #     # #     #",
                "  ###    #####  #######  #####       #   #####   #####    #      #####   ##### "
        );
        int height = digits[0].lines.length;

        // ввод числа с клавы
        System.out.println("Введите число ");
        Scanner sc = new Scanner(System.in);
        long Res = sc.nextInt();

        String str = Long.toString(Res);
        String[]numb=str.split("");
        int number[] = new int[numb.length];
        for (int i = 0; i < numb.length; i++) {
            number[i] = Integer.parseInt(numb[i]);
           }

        for (int i = 0; i < height; i++) {
            for (int digit : number) {
                System.out.print(digits[digit].lines[i] + " ");
            }
            System.out.println();
        }
    }
}