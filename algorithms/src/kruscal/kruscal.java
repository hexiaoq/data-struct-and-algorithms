package kruscal;


import java.util.Arrays;

public class kruscal {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs, data, weight);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();

        minTree.kruscal(graph);


    }
}

//创建最小生成树->村庄的图
class MinTree {
    public void kruscal(MGraph graph) {
//建立每个点的终点集合
        int[] end = new int[graph.verxs];
        Edata[] edata = getedges(graph);
        //让每条边按权值排序
        Arrays.sort(edata);
        for (int i = 0; i < graph.getedges(); i++) {
            int data1 = graph.getindex(edata[i].data1);
            int data2 = graph.getindex(edata[i].data2);

            int end1 = getend(end, data1);
            int end2 = getend(end, data2);
            if (end1 != end2) {//如果两个点的终点不相同,则后者是前者的下一个顶点,即二者共用同一个终点
                end[end1] = end2;
                System.out.println("边" + graph.data[data1] + "--->" + graph.data[data2] + "  " + "权值" + edata[i].weight);
            }

        }

    }


    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public Edata[] getedges(MGraph graph) {
        Edata[] edata = new Edata[graph.getedges()];
        int c = 0;
        for (int i = 0; i < graph.verxs; i++) {
            for (int j = 0; j < graph.verxs; j++) {
                if (graph.weight[i][j] != 10000) {
                    edata[c] = new Edata(graph.data[i], graph.data[j], graph.weight[i][j]);
                    c++;
                }

            }
        }
        return edata;
    }

    //获得每个点的终点,以判断是否形成回路
    private int getend(int[] end, int i) {
        while (end[i] != 0) {
            //获得i的下一个顶点,并不断循环获得下一个顶点直至获得终点
            i = end[i];

        }
        return i;
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

    //获得所有边的数量
    public int getedges() {
        int c = 0;
        for (int i = 0; i < verxs; i++) {
            for (int j = 0; j < verxs; j++) {
                if (weight[i][j] != 10000) {
                    c++;
                }

            }
        }
        return c;
    }

    //获得顶点对应的下标
    public int getindex(char i) {
        for (int i1 = 0; i1 < data.length; i1++) {
            if (data[i1] == i)
                return i1;
        }
        return -1;
    }

}

class Edata implements Comparable<Edata> {
    public char data1;
    public char data2;
    public int weight;

    @Override
    public String toString() {
        return "Edata{" +
                "data1=" + data1 +
                ", data2=" + data2 +
                ", weight=" + weight +
                '}';
    }

    public Edata(char data1, char data2, int weight) {
        this.data1 = data1;
        this.data2 = data2;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edata o) {
        return weight - o.weight;
    }
}
