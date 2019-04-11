package DzLess4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int size_y=5;
    static int size_x=5;
    static char[][] field=new char [size_y][size_x];
    //static int[][] copyField=new int[size_y][size_x];
    static char PLAYER_DOT = 'X';
    static char AI_DOT = 'O';
    static char EMPTY_DOT = '.';
    static int vinNum=4; //какое количество фишек подряд надо собрать для победы
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

    //ищет в массиве максимально длинные комбинации от vinNum-1 до 1, возвращает координаты хода для ИИ
    public static int[] aiCoordinate() {
        int[] coordinate=new int[2];
        int summ1=1;
        //ищем самую длинную цепочку
        for (int i = vinNum-1; i >0 ; i--) {
            for (int j = 0; j <size_y ; j++) {
                for (int k = 0; k <size_x ; k++) {
                    if (field[j][k]==PLAYER_DOT) {
                    //горизонталь
                    int a=1;
                        summ1=1;
                    while ((k+a)<size_x&&field[j][k+a]==PLAYER_DOT)
                     {
                           a++;
                           summ1=summ1+1;
                        };
                    if (summ1==i&&ifSellValid((k+a),j)) {
                        coordinate[0]=k+a;
                        coordinate[1]=j;
                        return coordinate;
                    }
                    else if (summ1==i&&ifSellValid((k-1),j)) {
                        coordinate[0]=k-1;
                        coordinate[1]=j;
                        return coordinate;
                    }
                    //вертикаль
                    a=1;
                    summ1=1;
                    while ((j+a)<size_y&&field[j+a][k]==PLAYER_DOT)
                      {
                         a++;
                          summ1=summ1+1;
                            };
                        if (summ1==i&&ifSellValid(k,j+a)) {
                            coordinate[0]=k;
                            coordinate[1]=j+a;
                            return coordinate;
                        }
                        else if (summ1==i&&ifSellValid(k,j-1)) {
                            coordinate[0]=k;
                            coordinate[1]=j-1;
                            return coordinate;
                        }
                    //диагональ вправо
                        a=1;
                        summ1=1;
                        while ((j+a)<size_y&&(k+a)<size_x&&field[j+a][k+a]==PLAYER_DOT)
                        {
                                a++;
                            summ1=summ1+1;
                            };
                        if (summ1==i&&ifSellValid(k+a,j+a)) {
                            coordinate[0]=k+a;
                            coordinate[1]=j+a;
                            return coordinate;
                        }
                        else if (summ1==i&&ifSellValid(k-1,j-1)) {
                            coordinate[0]=k-1;
                            coordinate[1]=j-1;
                            return coordinate;
                        }

                     //диагональ влево
                        a=1;
                        summ1=1;
                        while ((j+a)<size_y&&(k-a)>0&&field[j+a][k-a]==PLAYER_DOT)
                             {
                                a++;
                                 summ1=summ1+1;
                            };
                        if (summ1==i&&ifSellValid(k-a,j+a)) {
                            coordinate[0]=k-a;
                            coordinate[1]=j+a;
                            return coordinate;
                        }
                        else if (summ1==i&&ifSellValid(k+1,j-1)) {
                            coordinate[0]=k+1;
                            coordinate[1]=j-1;
                            return coordinate;
                        }

                }
            }

        }}
        coordinate[0]=random.nextInt(size_x);
        coordinate[1]=random.nextInt(size_y);
        return coordinate;

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

        if (x < 0 || y < 0 || x > size_y- 1 || y > size_x - 1) {
            return false;
        }
        if (field[y][x] == EMPTY_DOT) return true;
        else return false;
    }
    public static void initField() {
        for (int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }
    public static void setSym(int x, int y, char sym) {
        field[y][x] = sym;
    }
    public static void playerStep() {
        int x,y;
        do {
            System.out.println("Введите координаты: X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!ifSellValid(x,y));
        setSym(x,y,PLAYER_DOT);
    }



    public static void aiStep() {
        int x,y;

            System.out.println("Ход SkyNet");
            //добавляем искусственный интеллект
            x=aiCoordinate()[0];
            y = aiCoordinate()[1];

        setSym(x,y,AI_DOT);
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

    public static boolean checkWin(char sym) {
        int summ1, summ2, summ3, summ4;
        for (int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                if (field[i][j]==sym) {
                    //горизонталь
                    summ1=0;
                    for (int k = 0; k <vinNum&&j+k<size_x; k++) {
                        if (field[i][j+k]==sym) summ1++;
                    }
                    //вертикаль
                    summ2=0;
                    for (int k = 0; k <vinNum&&i+k<size_y; k++) {
                        if (field[i+k][j]==sym) summ2++;
                    }
                    //диагональ вправо
                    summ3=0;
                    for (int k = 0; k <vinNum&&i+k<size_y&&j+k<size_x; k++) {
                       if(field[i+k][j+k]==sym) summ3++;
                    }
                    //диагональ влево
                    summ4=0;
                    for (int k = 0; k <vinNum&&j-k>0&&i+k<size_y; k++) {
                        if(field[i+k][j-k]==sym) summ4++;
                    }
                    if (summ1==vinNum||summ2==vinNum||summ3==vinNum||summ4==vinNum)
                        return true;

                }
            }

        } return false;
        }
    }


