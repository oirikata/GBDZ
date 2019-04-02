package DzLess2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
     /*задание 1: Задать целочисленный массив, состоящий из элементов 0 и 1
      С помощью цикла и условия заменить 0 на 1, 1 на 0 */
        int [] arr1 = {1,0,0,1,1,0,1,1,0,0};
        for (int i = 0; i <arr1.length-1 ; i++) {
            if (arr1[i]==1) arr1[i]=0;
                    else arr1[i]=1;
        }
        System.out.println(Arrays.toString(arr1));

     //задание 2
     // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int [] arr2 = new int[8];
        for (int i = 0; i <arr2.length ; i++) {
            arr2[i]=3*i;
        }
        System.out.println(Arrays.toString(arr2));

     //задание 3
     //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i <arr3.length ; i++) {
            if (arr3[i]<6) arr3[i]=arr3[i]*2;
        }
        System.out.println(Arrays.toString(arr3));
    //задание 4
    /*Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     и с помощью цикла(-ов) заполнить его диагональные элементы единицами */
        int[][] arr4 = new int[6][6];
        for (int i = 0; i <arr4.length ; i++) {
           arr4[i][i]=1;
           arr4[i][arr4.length-i-1]=1;
        }
        for (int i = 0; i < arr4.length; i++) {
        System.out.println(Arrays.toString(arr4[i])); }

     //задание 5
     //Задать одномерный массив и найти в нем минимальный и максимальный элементы
        int[] arr5={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int max=0;
        int min=arr5[0];
        for (int i = 0; i <arr5.length ; i++) {
            if (arr5[i]>max) max=arr5[i];
            else if (arr5[i]<min) min=arr5[i];
        }
        System.out.println("Минимальное значение: "+min+" ,Максимальное значение: " +max);

     //задание 6
        int[] arr6= {6,2,3,1,};
        boolean b = checkBalance(arr6);
        System.out.println((b==true) ? "Массив сбалансирован" : "массив не сбалансирован");

    //задание 7
        System.out.println(Arrays.toString(arr3));
        changeMassPosition(arr3,3);

    }


    public static boolean checkBalance(int[] arr) {
        int summ1=0;
        int summ2=0;
        boolean result=false;
        for (int i = 0; i <arr.length ; i++) {
            summ2=summ2+arr[i];
        }
        for (int i = 0; i <arr.length ; i++) {
            summ1=summ1+arr[i];
            if (summ1==summ2-summ1) {
                result= true;
                break;
            }
        }
        return result;


    }
    public static void changeMassPosition (int[] arr, int pos) {
        int buff1=0;
        int buff2=0;
        int count=0;
        if (pos >0) {
            do {
                buff1=arr[0];
                arr[0]=arr[arr.length-1];
                for (int i = 1; i <arr.length ; i++) {
                    buff2=arr[i];
                    arr[i]=buff1;
                    buff1=buff2;
                }

                count=count+1;
            } while (count<pos);
            System.out.println(Arrays.toString(arr));
        }
        else if (pos<0) {
            do {
                buff1=arr[arr.length-1];
                arr[arr.length-1]=arr[0];
                for (int i = arr.length-1; i >=0 ; i--) {
                    buff2=arr[i];
                    arr[i]=buff1;
                    buff1=buff2;
                }

                count=count-1;
            } while (count>pos);
            System.out.println(Arrays.toString(arr));
        }
        else System.out.println(Arrays.toString(arr));
    }
}

