package DzLess4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int size_y=3;
    static int size_x=3;
    static char[][] field=new char [size_y][size_x];
    static char PLAYER_DOT = 'X';
    static char AI_DOT = 'O';
    static char EMPTY_DOT = '.';


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        initField();
        printField();

    }
    public static void printField () {
        System.out.print("| ");
        for (int i = 0; i <size_x ; i++) {
            System.out.print("|"+ (i+1));
        }
        System.out.println("|");
        for (int i = 0; i <size_y ; i++) {
            System.out.print("|"+(i+1));
            for (int j = 0; j <size_x ; j++) {
                System.out.print("|"+field[i][j]);
            }
            System.out.println("|");
        }
    }
    public static void initField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

}
