package recursion;
//迷宫问题
public class migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //使地图的边界置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][2] = 1;
        map[3][1] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();

        }
        System.out.println("分割线");
        setway(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();


        }
    }

    /**
     * 走的策略为 向下 向右 向左 向上
     * @param map
     * @param i j为开始的位置
     * @return true为走完,false为未走完
     */
    public static boolean setway(int[][] map,int i,int j)
    {//终止递归的条件
        if(map[6][5]==2)
        return true;
    if(map[i][j]==0)
    {
        map[i][j]=2;
        if(setway(map,i+1,j))
        {return true;
    }
        else if(setway(map,i,j+1))
        {
            return true;
        }
        else if(setway(map,i,j-1))
        {
            return true;
        }
        else if(setway(map,i-1,j))
        {
            return true;
        }
        else { map[i][j]=3;
            return  false;
        }

        }
    //终止的递归的条件 当map[i][j]不为0,说明走过但后续走不通或者是墙,所以不再走
    else
        return false;

    }

}
