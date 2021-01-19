package sort;

import java.util.Arrays;

public class selectsort {
    public static void main(String[] args) {
        int[] arr = {13, -1, 5, 5, 2, 6, 1};
        for (int i = 0; i < arr.length-1; i++) {
            //假定第一个值即为最小值
            int mixindex=i;
            int mix=arr[i];
            //通过比较找到最小的值
            for (int j = i+1; j <arr.length ; j++) {
                if(mix>arr[j])
                {
                    mix=arr[j];
                    mixindex=j;
                }
            }

            arr[mixindex]=arr[i];
            arr[i]=mix;
            System.out.print("第"+(i+1)+"趟排序:");
            System.out.println(Arrays.toString(arr));

        }
    }
}
