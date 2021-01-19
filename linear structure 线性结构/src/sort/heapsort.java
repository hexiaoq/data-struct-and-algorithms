package sort;

import java.util.Arrays;

//堆排序
public class heapsort {
    public static void main(String[] args) {
//
//        int[] arr={4,6,8,5,9,3,15,63,21};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]= (int) (Math.random()*8000000);
        }
        long start=System.currentTimeMillis();
       heapsort(arr);
//        System.out.println(Arrays.toString(arr));
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void heapsort(int[] arr)
    {//arr.length/2-1是第一个非叶子节点
        for(int i=arr.length/2-1;i>=0;i--)
    {
        adjust(arr,arr.length,i);

    }
    int tem=0;
        //将第一个的数与最后一个数交换,然后将前n-1个数继续堆排序
        for (int i = arr.length-1; i >0 ; i--) {
            tem=arr[0];
            arr[0]=arr[i];
            arr[i]=tem;
            adjust(arr,i,0);
        }

    }
    public static void adjust(int[] arr,int length,int i)
    {
           int tem=arr[i];
        for (  int k=2*i+1; k <length ; k=k*2+1) {
            //k为i的左子节点

            //选取左右节点中最大的与父节点比较
            if( k+1<length&&arr[k]<arr[k+1])
            {
                k++;
            }
            if(arr[k]>tem)
            {
                arr[i]=arr[k];
                i=k;

            }
            //如果子节点大于父节点,则会进行交换,这样可能会打破子树的平衡,所以要对子树进行堆排
            //如果没交换,则不需要,因为堆排序是从下自上的,子树是已经进行过堆排序的,直接跳出for循环
            else {

                break;
            }

        }
        arr[i]=tem;
    }
}
