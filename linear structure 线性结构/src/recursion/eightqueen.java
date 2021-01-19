package recursion;

public class eightqueen {
    private int max = 8;
 int[] array = new int[max];

    public  void print()
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    //判断棋子是否在同一行同一列,或者同一斜线上
    public boolean judge(int n)
    {
        for (int i = 0; i <n ; i++) {
            //由于是一行一行摆放棋子所以同行不用管
            //前者判断不同列,数组的索引表示行数,值表示列数
            //后者判断斜线,只要行数差的绝对值等于列数差的绝对值,他们就在同一斜线上
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i]))
            {
                return false;
            }
        }
        //只有所有的都遍历完才能证明这个棋子的位置可行
        return true;

    }
    public  void putqueen(int n)
    {
        if(n==max)
        {
            print();
            return;
        }
        for (int i =0 ; i <max ; i++) {
            //先把当前这个皇后放在第i个位置
            array[n]=i;
            //如果当前这个位置符合,就保留这个位置,继续putqueen寻找下一行符合的位置
            //如果最后满足了回溯条件(n==max)就完成了if语句输出这种方案,然后进入for循环,找个该行中下一个满足条件的位置
            //如果不符合,也进入for循环
            if(judge(n))
            {
                putqueen(n+1);
            }

        }
    }



    public static   void main(String[] args) {
        eightqueen eightqueen=new eightqueen();
        eightqueen.putqueen(0);

    }
}
