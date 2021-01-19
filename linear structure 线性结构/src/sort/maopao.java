package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class maopao {
    public static void main(String[] args) {
//        int[] arr = {13, -1, 5, 7, 2, 6, 1};
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = 0; j < arr.length - i-1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int tem = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j]=tem;
//                }
//
//            }
//            System.out.print("第"+(i+1)+"趟排序:");
//            System.out.println(Arrays.toString(arr));
//        }
        //优化版 如果前几趟排序已经完成,则不必再排序
//        int[] arr = {13, -1, 5, 7, 2, 6, 1};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }
        long start=System.currentTimeMillis();
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag=false;
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j]=tem;
                    //如果完成交换,则说明还没排序完,flag置为真
                    flag=true;
                }

            }
            if(!flag)
            {  long end=System.currentTimeMillis();
                System.out.println(end-start);
                return;
            }
//            System.out.print("第"+(i+1)+"趟排序:");
//            System.out.println(Arrays.toString(arr));
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
