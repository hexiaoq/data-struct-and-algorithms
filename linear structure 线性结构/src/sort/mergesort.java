package sort;

import java.util.Arrays;

public class mergesort {
    public static void main(String[] args) {
//        int[] arr = {5, -1, 13, 7, 2, 6, 3,1};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }
        long start=System.currentTimeMillis();
        mergesort(arr,0,arr.length-1);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
    //分治法
    public static void mergesort(int[] arr,int begin,int end) {
        int mid=(end+begin)/2;
        //当分成容量为1的数组时,则回溯,并将容量为2及以上的数组排序
        if (end - begin != 0) {
            mergesort(arr, begin, mid);
            mergesort(arr, mid+1, end);

            twoorderto1(arr,begin,end,mid);
            //以下代码是两个有序数列合并的代码,可以封装成一个方法
//            int[] tem = new int[end - begin+1];
//            int i = begin;
//            int j = mid + 1;
//            int e = 0;
//            while (i <= mid && j <= end) {
//
//                if (arr[i] > arr[j]) {
//                    tem[e] = arr[j];
//                    j++;
//                    e++;
//                } else {
//                    tem[e] = arr[i];
//                    i++;
//                    e++;
//                }
//
//            }
//            // 把左边剩余的数移入数组
//            while(i<=mid){
//                tem[e++] = arr[i++];
//            }
//            // 把右边边剩余的数移入数组
//            while(j<=end){
//                tem[e++] = arr[j++];
//            }
//
//            for (int i1 = 0; i1 < tem.length; i1++, begin++) {
//                arr[begin] = tem[i1];
//
//            }
//            System.out.println(Arrays.toString(arr));

        }
        else return;
    }
    public static void twoorderto1(int[] arr,int begin,int end,int mid)
    {    int[] tem = new int[end - begin+1];
        int i = begin;
        int j = mid + 1;
        int e = 0;
        while (i <= mid && j <= end) {

            if (arr[i] > arr[j]) {
                tem[e] = arr[j];
                j++;
                e++;
            } else {
                tem[e] = arr[i];
                i++;
                e++;
            }

        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            tem[e++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=end){
            tem[e++] = arr[j++];
        }

        for (int i1 = 0; i1 < tem.length; i1++, begin++) {
            arr[begin] = tem[i1];

        }

    }

}
