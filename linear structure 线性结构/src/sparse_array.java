import java.io.*;

public class sparse_array {
    public static void main(String[] args) throws Exception {
        int[][] arr=new int[11][11];
        //1为黑棋,2为白棋,0为空
        arr[1][2]=1;
        arr[2][3]=2;
        arr[4][5]=1;
        //输出原始棋盘
        int sum=0;
        for (int[] ints : arr) {
            for (int i = 0; i <ints.length ; i++) {
                System.out.print(ints[i]);
                if (ints[i] != 0)
                {
                    //记录棋盘上的棋子总数
                    sum++;
                }
            }
            System.out.println();
        }
        //转换成稀疏数组
        //稀疏数组的行数为棋子数+1,列数永远为3
        int[][] sparse=new int[sum+1][3];
        sparse[0][0]=11;
        sparse[0][1]=11;
        sparse[0][2]=sum;
        int count=1;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (arr[i][j]!=0)
                {

                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=arr[i][j];
                    count++;

            }
        }
        }

        //输出稀疏数组
//        for (int[] ints : sparse) {
//            for (int i = 0; i < ints.length; i++) {
//                System.out.print(ints[i]);
//
//
//            }
//            System.out.println();
//        }
        //优化:保存到文件中 对象流可以传输数组
        File file=new File("chess.txt");
        FileOutputStream os=new FileOutputStream(file);
        ObjectOutputStream ob=new ObjectOutputStream(os);
        ob.writeObject(sparse);


        //从文件中读取
        FileInputStream is=new FileInputStream(file);
        ObjectInputStream ob2=new ObjectInputStream(is);
        int[][] toarr=(int[][])ob2.readObject();
        for (int[] ints : toarr) {
            for (int i = 0; i <ints.length ; i++) {
                System.out.print(ints[i]);
            }
            System.out.println();

        }
        //稀疏数组再转化为棋盘
        int[][] tem=new int[toarr[0][0]][toarr[0][1]];
        //只要把棋子赋值到棋盘上
        for (int i = 1; i <sum+1 ; i++) {
            tem[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        //输出棋盘
        for (int[] ints : tem) {
            for (int i = 0; i <ints.length ; i++) {
                System.out.print(ints[i]);
            }
            System.out.println();
        }



    }
}
