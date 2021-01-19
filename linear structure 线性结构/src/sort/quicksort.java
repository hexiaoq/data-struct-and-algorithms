package sort;

import java.util.Arrays;

//快排效率最高

public class quicksort {
    public static void main(String[] args) {
        int[] arr = {5, -1, 13, 7, 2, 6, 1,3};
//        int[] arr=new int[80000];
//        for (int i = 0; i <80000 ; i++) {
//            arr[i]= (int) (Math.random()*8000000);
//        }
        long start=System.currentTimeMillis();

        quicksort2(arr,0,arr.length-1);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(arr));
    }
    public  static void quicksort(int arr[],int left,int right) {
        int l = left;
        int r = right;
        int key=arr[left];
        while (l < r) {
            //以第一个值为基准,则需要从后面开始,反之亦然
            while(l<r&&arr[r]>=key)
            {
                r--;
            }

                arr[l]=arr[r];

            while (l<r&&arr[l]<key)
            {
                l++;
            }

                arr[r]=arr[l];



        }
        //每次交换的时候,key本该换过去的索引处不处理,最后再将key值放回,可以避免每次都给交换的值赋上key,增加效率
        arr[l]=key;
        //必须加上if语句,否则递归没有结束条件,栈会溢出
        if (l > left) {
            quicksort(arr,left,l-1);
        }
     if(r<right)
     {
         quicksort(arr,r+1,right);
     }

    }
    //简洁版
    public  static void quicksort2(int arr[],int left,int right) {
        int index = deal(arr, left, right);
        if(index==-1)
            return;
//        if(left<index-1) {
//            quicksort2(arr, left, index - 1);
//        }
//        if(index+1<right) {
//
//        }
        quicksort2(arr, left, index - 1);
        quicksort2(arr, index + 1, right);

    }
    public static int deal(int arr[],int left,int right){
        if(left>=right)
        {return -1;}
        int l=left;
        int r=right;
        int key=arr[right];
        while(l<r)
        {
            while (l<r&&arr[l]<=key)
            {l++;
        }
            arr[r]=arr[l];
            while (l<r&&arr[r]>key)
            {
                r--;
            }
            arr[l]=arr[r];
    }
        arr[r]=key;
    return r;}

}
