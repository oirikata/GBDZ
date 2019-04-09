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
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {


        initField();
        printField();
        while (true) {
            playerStep();
            printField();
            if(checkWin(PLAYER_DOT)) {
                System.out.println("Player win!!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!!");
                break;
            }
            aiStep();
            printField();
            if(checkWin(AI_DOT)) {
                System.out.println("SkyNet win!!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!!");
                break;
            }
        }

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
    public static boolean ifSellValid (int x, int y){

        if (x < 0 || y < 0 || x > size_x- 1 || y > size_y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }
    public static void initField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }
    public static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }
    public static void playerStep() {
        int x,y;
        do {
            System.out.println("Введите координаты: X Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!ifSellValid(y,x));
        setSym(y,x,PLAYER_DOT);
    }

    public static void aiStep() {
        int x,y;
        do {
            System.out.println("Введите координаты: X Y (1-3)");
            x = random.nextInt(size_x);
            y = random.nextInt(size_y);
        } while (!ifSellValid(y,x));
        setSym(y,x,AI_DOT);
    }
    public static boolean isFieldFull() {
        for (int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(){
        
    }

}
