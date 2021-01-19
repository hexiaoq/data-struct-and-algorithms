package search;

import java.util.Arrays;

//斐波那契查找法
public class feibosearch {
    public static void main(String[] args) {
        int[] arr = {1,3, 5, 7, 8, 9, 11, 25, 36};


      int[] feb=feiboarray();
      int oldlengh=arr.length;
      int k=2;
      //feb[k]-1=数组的长度
      while(arr.length>feb[k]-1)
      {k++;
      }
      arr=Arrays.copyOf(arr,feb[k]-1);

      //为0的部分用最后一个数 补齐
        for (int i = oldlengh; i <arr.length ; i++) {
            arr[i]=arr[oldlengh-1];

        }
        System.out.println(Arrays.toString(arr));
        int febsearch = febsearch(arr, 0, arr.length - 1, 36, feb, k);
        System.out.println(febsearch>oldlengh-1?oldlengh-1:febsearch);


    }
    public static int[] feiboarray()
    {
        int a[]=new int[10];
        a[0]=1;a[1]=1;
        for (int i = 2; i <a.length ; i++) {
            a[i]=a[i-1]+a[i-2];
        }
        return a;
    }

    //无相同数
    public static int febsearch(int arr[], int left, int right, int look,int[] feb,int k) {
        int l = left;
        int r = right;
        int mid =l+feb[k-1]-1;
        if (l <= r) {
            if (arr[mid] == look) {
                return mid;
            }
            //向左递归
            if (arr[mid] > look) {
                return febsearch(arr, l, mid - 1, look,feb,--k);

            }
            //向右递归
            else
                return febsearch(arr, mid + 1, r, look,feb,k=k-2);


        }
        return -1;

    }
}
