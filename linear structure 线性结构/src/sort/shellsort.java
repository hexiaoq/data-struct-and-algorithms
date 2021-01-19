package sort;

import java.util.Arrays;
import java.util.Date;

public class shellsort {
    public static void main(String[] args) {
//        int[] arr={3,5,6,4,9,8,2,7,1,0};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }
        long start=System.currentTimeMillis();
        int e=1;
        //先分组
        for (int gap =arr.length/2; gap >0 ; gap=gap/2) {
            //遍历分组后的每一个组
            for (int i = 0; i <gap; i++) {
                //分组后再对每组采用直接插入排序,i+gap永远为本组的第二个数
                for (int j = i+gap; j <arr.length ; j=j+gap) {
                    int c=j-gap;
                    int tem=arr[j];
                    while(c>=0&&tem<arr[c])
                    {
                        arr[c+gap]=arr[c];
                        c=c-gap;
                    }
                    //发现这个位置上的数小于我了,则可以令前一个位置为我
                    arr[c+gap]=tem;


                }



            }
//            System.out.print("第" + (e++) + "趟排序:");
//            System.out.println(Arrays.toString(arr));
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }






}
