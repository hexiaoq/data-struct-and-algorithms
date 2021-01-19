package recursion;

public class jiecheng {
    public static void main(String[] args) {
        System.out.println(jiecheng(10));

    }
    public static int jiecheng(int n)
    {
        if (n==1)
        {
            return 1;
        }
        else {
            return jiecheng(n-1)*n;
        }
    }
}
