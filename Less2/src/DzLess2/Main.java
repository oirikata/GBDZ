package DzLess2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
     int [] arr1 = {1,0,0,1,1,0,1,1,0,0};
        for (int i = 0; i <arr1.length-1 ; i++) {
            if (arr1[i]==1) arr1[i]=0;
                    else arr1[i]=1;
        }
        System.out.println(Arrays.toString(arr1));


    }
}

