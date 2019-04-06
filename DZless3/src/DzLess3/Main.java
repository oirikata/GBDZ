package DzLess3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* Написать программу, которая загадывает случайное число от 0 до 9,
        и пользователю дается 3 попытки угадать это число.
        При каждой попытке компьютер должен сообщить больше ли указанное пользователем
        число чем загаданное, или меньше. После победы или проигрыша выводится запрос –
        «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет). */

       playNumbersGame();

    }

    private static void playNumbersGame() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int again=1;
        do {
            int number = rnd.nextInt(10);
            System.out.println("Мы загадали число от 0 до 9. Угадай число за 3 попытки");
            System.out.println(number);
            boolean win=false;
            int t=0;
            do {
                int guess = sc.nextInt();
                if (guess > number) System.out.println("Неверно. Загаданное число меньше");
                else if (guess < number) System.out.println("Неверно. Загаданное число больше");
                else {
                    win=true;
                    break;
                }
                t++;
            } while ( t<3);
            System.out.println((win==true)?"Вы выиграли! ":"Вы проиграли. Загаданное число: "+number);
            System.out.println("Повторить игру еще раз? 1- да/0-нет");
            again = sc.nextInt();
        } while (again==1);

    }


}
