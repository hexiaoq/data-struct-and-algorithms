package pim;

import java.util.Arrays;

public class prim {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs,data,weight);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();

        minTree.showGraph(graph);
        minTree.prim(graph,1);

    }

}

//创建最小生成树->村庄的图
class MinTree {


    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    /**
     *
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void prim(MGraph graph, int v) {
        int[] visited=new int[graph.verxs];
        visited[v]=1;
        int h1=-1;
        int h2=-1;

        for (int k = 1; k <graph.verxs ; k++) {
            int minweight=10000;
            //找到已有顶点的未存入边集的最小边
        for (int i = 0; i <graph.verxs ; i++) {
            for (int j = 0; j <graph.verxs ; j++) {
                if(visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minweight)
                {
                    minweight=graph.weight[i][j];
                    h1=i;h2=j;
                }


                }

            }
            System.out.println("边"+graph.data[h1]+"--->"+graph.data[h2]+"  "+"权值"+minweight);
        visited[h2]=1;

        }


    }
}
class MGraph {
    int verxs; //表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵

    public MGraph(int verxs, char[] data, int[][] weight) {
        this.verxs = verxs;
        this.data = data;
        this.weight = weight;
    }
}
