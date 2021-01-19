package search;

import java.util.Arrays;

//二分查找
public class midsearch {
    static int index = 0;
    static int[] re = new int[10];

    public static void main(String[] args) {
//        int[] arr = {1, 3, 3, 3, 5, 8, 11, 25, 36};
        int[] arr={3,15,4,4,6,3,19,5,9,4};
//        System.out.println(midsearch1(arr,0,arr.length-1,5));
        midsearch2(arr, 0, arr.length - 1, 15);
        System.out.println(Arrays.toString(re));


    }

    //无相同数
    public static int midsearch1(int arr[], int left, int right, int look) {
        int l = left;
        int r = right;
        int mid = (l + r) / 2;
        if (l <= r) {
            if (arr[mid] == look) {
                return mid;
            }
            //向左递归
            if (arr[mid] > look) {
                return midsearch1(arr, l, mid - 1, look);

            }
            //向右递归
            else
                return midsearch1(arr, mid + 1, r, look);


        }
        return -1;

    }

    //有相同数
    public static void midsearch2(int arr[], int left, int right, int look) {
        int l = left;
        int r = right;
        int mid = (l + r) / 2;
        if(l <= r) 
        {
            if (arr[mid] == look) {
                re[index] = mid;
                index++;

            }
            //向左递归
            midsearch2(arr, l, mid - 1, look);


            //向右递归
            midsearch2(arr, mid + 1, r, look);

        }

    }

}



