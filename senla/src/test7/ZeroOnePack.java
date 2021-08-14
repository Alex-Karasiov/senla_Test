package test7;

import java.util.Scanner;

public class ZeroOnePack {
    // N представляет количество объектов, V представляет нагрузку
    int N,V;
    // Используется для хранения веса каждого объекта
    private int[] weight;
    // Сохраняем доход каждого объекта
    private int[] value;
    // Двумерный массив, используемый для сохранения максимальной прибыли в каждом состоянии
    private int[][] F;


     // решения F [0 .. N] [0 .. V],

    public void ZeroOnePackNonRecursive() {
        // Инициализируем двумерный массив F
        for(int j = 0; j <= V; j++) {
            F[0][j] = 0;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                // j i-й объект
                if(j >= weight[i]) {
                    F[i][j] = Math.max(F[i - 1][j - weight[i]] + value[i], F[i - 1][j]);
                }else {
                    F[i][j] = F[i - 1][j];
                }
            }
        }

        // Распечатываем  F [N] [V]
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * Решите оптимальное значение F [n] [m], какие элементы можно выбрать для получения максимального значения,
     * но будет выведен только один случай
     * @param n означает первые n объектов, n <= N
     * @param v - вместимость, v <= V
     */
    public void printResult(int n, int v) {
        boolean[] isAdd = new boolean[n + 1];

        for(int i = n; i >= 1; i--) {
            if(F[i][v] == F[i-1][v])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(isAdd[i] + " ");
        }
        System.out.println();
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        weight = new int[N + 1];
        value = new int[N + 1];
        F = new int [N + 1] [V + 1];
        // Обратите внимание, что это N + 1, потому что требуется начальное состояние
        // F [0] [0], что означает, что первые 0 предметов помещаются в самый большой кейс
        // с пространством 0 Доход

        for(int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            value[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        System.out.println("* Формат ввода:");
        System.out.println(" 5 10");
        System.out.println("2 2 6 5 4");
        System.out.println(" 6 3 5 4 6");

        ZeroOnePack zop = new ZeroOnePack();
        zop.init();
        zop.ZeroOnePackNonRecursive();
        zop.printResult(zop.N,zop.V);
    }

}
