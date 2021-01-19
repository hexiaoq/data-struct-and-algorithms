package dynamic;

//动态规划,  01背包问题
public class bagproblem {
    public static void main(String[] args) {
        //物品的重量
        int[] weight = {1, 4, 3};
        //物品的价值
        int[] price = {1500, 3000, 2000};
        //物品的数量
        int num = weight.length;
        //背包的容量
        int m = 4;
        //v[i][j]数组,i表示商品种类,j表示背包容量
        int[][] v = new int[num + 1][m + 1];
        int[][] path = new int[num + 1][m + 1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {//背包装第i种商品还有容量剩余,继续装第i-1种商品并和上次情况比较
                    if (price[i - 1] + v[i - 1][j - weight[i - 1]] > v[i - 1][j]) {
                        v[i][j] = price[i - 1] + v[i - 1][j - weight[i - 1]];
                        //只有这种情况才是最优解,需要记录,如果小于则v[i-1][j]是最优解,但他已经在自己的那一轮被记录了
                        path[i][j] = 1;

                    }
                    //如果小于则v[i-1][j]是最优解,但他已经在自己的那一轮被记录了
                    else v[i][j] = v[i - 1][j];
                }


            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {

                if(path[i][j]==1)
                {
                    System.out.print(v[i][j]+"*" + " ");
                }
                else System.out.print(v[i][j] + " ");

            }
            System.out.println();
        }


    int i = path.length - 1;
    int j = path[0].length - 1;


//输出最后一次放商品的记录,和剩余背包空间的放商品的记录
        while(i >0&&j >0)

    {
        if (path[i][j] == 1) {
            System.out.println("把第" + i + "个商品放入背包中");
            j = j - weight[i - 1];
        }
        i--;
    }
}


    }


