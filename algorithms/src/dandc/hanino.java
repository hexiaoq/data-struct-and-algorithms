package dandc;

public class hanino {
    public static void main(String[] args) {


        haninotower(5, 'a', 'b', 'c');

    }
    public static void haninotower(int n,char a,char b,char c)
    {if(n==1)
        System.out.println("第1个盘从"+a+"--->"+c);
    else {
        //多于一个盘则把上面n-1个盘看成是一个盘,当成两个盘处理
        // 最上面的盘a到b
        haninotower(n - 1, a, c, b);
        //最下面的盘从a到c
        System.out.println("第" + n + "个盘从" + a + "--->" + c);
        //b上的盘从b到c
        haninotower(n - 1, b, a, c);
    }
    }

}
