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
        for (int j = 0; j <arr2.length ; j++) {
            arr2[j]=3*j;
        }
        System.out.println(Arrays.toString(arr2));

     //задание 3
     //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int k = 0; k <arr3.length ; k++) {
            if (arr3[k]<6) arr3[k]=arr3[k]*2;
        }
        System.out.println(Arrays.toString(arr3));
    //задание 4
    



    }
}

