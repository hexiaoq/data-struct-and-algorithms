package Tree;

public class arraytreedemo {
    public static void main(String[] args) {
int[] arr={1,2,3,4,5,6,7};
        arraytree arraytree = new arraytree(arr);
        arraytree.show();

    }
}
class arraytree{
    private int[] arr;

    public arraytree(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
    public void show()
    {
        this.midshow(0);
    }
    public void frontshow(int n)
    {
        System.out.println(arr[n]);
        if(2*n+1<=arr.length-1)
        {
            frontshow(2*n+1);
        }
        if(2*n+2<=arr.length-1)
        {
            frontshow(2*n+2);
        }

    }
    public void midshow(int n)
    {

        if(2*n+1<=arr.length-1)
        {
            midshow(2*n+1);
        }
        System.out.println(arr[n]);
        if(2*n+2<=arr.length-1)
        {
            midshow(2*n+2);
        }

    }
}
