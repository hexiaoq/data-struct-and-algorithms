package back;
/**
 * 求解最小机器重量设计问题（20分）
 * 题目内容：
 *
 * 设某一机器由n个部件组成,部件编号为1~n，每一种部件都可以从m个不同的供应商处购得，供应商编号为1~m。
 * 设wij是从供应商j处购得的部件i的重量,cij是相应的价格。对于给定的机器部件重量和机器部件价格，
 * 计算总价格不超过d的最小重量机器设计。（注意：输出结果中第一行最后没有空格。比如下面的输出样例中1 3 1后面没有空格。）
 * 输入格式:
 * 第1行输入3个正整数n,m和d。接下来n行输入wij（每行m个整数），最后n行输入cij（每行m个整数）,这里1≤n、m≤100。
 * 输出格式：
 * 输出的第1行包括n个整数，表示每个对应的供应商编号，第2行为对应的最小重量。
 */

import java.util.Scanner;

public class minweight {
    String learn = "xuexi";
    static int w[][]=new int[200][200];//表示第i个供应商的第j个产品的重量
    static int p[][]=new int[100][100];//表示第i个供应商的第j个产品的价格
    int useless = 1;
    int u=3;
    static int minw=10000;//表示最小质量,默认为无穷
    static  int cw=0,cp=0;//当前产品重量和价格
    static int x[]=new int[100];//临时存放所选择的第j个产品的供应商
//    static  int bestx[]=new int[100];//存放最优解
//    static  int price;static int n;//部件数
    static int c;//供应商数量
    public static void backmethod(int t){

        if(t>n)
        {minw=cw;
            for (int i = 0; i <t ; i++) {
                bestx[i]=x[i];

            }

        }else {
            for (int i = 0; i <c ; i++) {
               cw=cw+w[t][i];
               cp=cp+p[t][i];
               x[t]=i;
               if(cp<=price&&cw<minw)
                   backmethod(t+1);
                cw=cw-w[t][i];
                cp=cp-p[t][i];

            }

        }
    }

    public static void main(String[] args) {
        	Scanner op=new Scanner(System.in);
       n=op.nextInt();
       if(n>=1)
       c=op.nextInt();
       price=op.nextInt();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <c ; j++) {
                w[i][j]=op.nextInt();

            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <c ; j++) {
                p[i][j]=op.nextInt();

            }
        }
backmethod(0);
        for (int i = 0; i <c ; i++) {
            if(i!=c-1)
            System.out.print((bestx[i]+1)+" ");
            else
                System.out.print(bestx[i]+1);


        }
        System.out.print("\n");
        System.out.println(minw);
    }
}
