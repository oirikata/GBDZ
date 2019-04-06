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

       //Задание 2: игра в слова.
        playWordsGame();



    }

    private static void playNumbersGame() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int again=1;
        do {
            int number = rnd.nextInt(10);
            System.out.println("Мы загадали число от 0 до 9. Угадай число за 3 попытки");
           // System.out.println(number);
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
        //sc.close();
    }
    private static void playWordsGame(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        boolean win=false;
        int again=1;

        String arr[]={"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        do {
        String word = arr[rnd.nextInt(arr.length)];
        System.out.println("Мы загадали число от 0 до 9. Угадай число за 3 попытки");
        //System.out.println(word);
        do {
            String guess = sc.next();
            if (guess.equals(word)==false)
            {
                System.out.println("Увы, мы загадали другое слово. Посмотри, может быть, ты угадал какие-то буквы?");
                int leng= (word.length()<guess.length()?word.length():guess.length());
                for (int i = 0; i < leng; i++) {
                    if (guess.charAt(i)==word.charAt(i))
                        System.out.print(word.charAt(i));
                    else System.out.print("#");
                }
                for (int i = leng; i <15 ; i++) {
                    System.out.print("#");
                }
                System.out.println("#");

            }
            else
                win=true;

        } while (win==false);
        win=false;
        System.out.println("Поздравляем, вы выиграли!");
        System.out.println("Повторить игру еще раз? 1- да/0-нет");
        again = sc.nextInt();
    } while (again==1);
        sc.close();
    }


}
