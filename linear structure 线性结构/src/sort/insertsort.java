package sort;

import java.util.Arrays;

public class insertsort {
    public static void main(String[] args) {
//        int[] arr = {13, -1, 5, 7, 2, 6, 1};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }
        long start=System.currentTimeMillis();

        for (int i = 1; i < arr.length; i++) {
            int insertvalue = arr[i];
            //带插入的数的前一个数的下标
            int insertindex = i - 1;
            //前一个条件说明带插入的数前面还有空间,后者说明前一个数的位置不是应该插入的位置
            while (insertindex >= 0 && arr[insertindex] > insertvalue) {
                //待插入的数和他的前一个数交换,然后继续向前找比它小的数
                //找到则跳出while,到了该插入的位置
                arr[insertindex + 1] = arr[insertindex];
                arr[insertindex] = insertvalue;
                insertindex--;

            }
//            System.out.print("第" + (i) + "趟排序:");
//            System.out.println(Arrays.toString(arr));
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
