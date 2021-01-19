package dijkstra;

import java.util.Arrays;

public class dijkstra {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};

        Graph graph = new Graph(vertex, matrix);

        graph.showGraph();
        graph.dsj(6);
        graph.vv.show();




    }
}
class Graph {
    private char[] vertex; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    public visitedvertex vv; //已经访问的顶点的集合

    // 构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }



    // 显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }
    public void dsj(int index)
    {vv=new visitedvertex(vertex.length,index);
       update(index);
        for (int i = 0; i <vertex.length ; i++) {
            index=vv.updateArr();
            update(index);

        }


    }
    public void update(int index)
    {//出发节点到此节点的距离和原始节点(第一个出发节点)到出发节点距离的和
        int len=0;
        for (int i = 0; i <vertex.length ; i++) {
            len=vv.dis[index]+matrix[index][i];
            //如果len小于原本数组中记录的原始节点到此节点的距离,则更新数组中的最小距离为len,被访问过的顶点已是最小距离不用更新
            if(vv.dis[i]>len&&vv.visited[i]==0)
            {
                vv.dis[i]=len;
                //把i节点的前驱结点由原始节点更新为出发节点
                vv.prevertex[i]=index;
            }
        }

    }
}
class visitedvertex
{
    public int[] visited;
    public int[] prevertex;
    public int[] dis;

    public visitedvertex(int vertexs,int index) {
        //被访问过的顶点置为1,顶点被访问过则说明到这个顶点的最小dis已确定,dis里到这个点的距离则不会再发生改变
        this.visited =new int[vertexs];
        this.prevertex=new int[vertexs];
        this.dis =new int[vertexs];

        Arrays.fill(dis,65535);
        dis[index]=0;
        visited[index]=1;


    }
    /**
     * 继续选择并返回新的访问顶点， 比如这里的G 完后，就是 A点作为新的访问顶点(访问顶点即为出发顶点,不是原始顶点)
     * 通过dis[i]<min条件,每次都优先选择dis集合里最小的边的顶点为下一个访问点,则之前访问顶点到这个顶点所产生的最短路径就是整个图里到这个顶点的最短路径,
     * @return
     */
    public int updateArr() {
       int  index = 0,min=65536;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == 0 &&dis[i]<min) {
                min=dis[i];
                index = i;
            }
        }
        //更新 index 顶点被访问过
        visited[index] = 1;
        return index;
    }
    public void show() {

        System.out.println("==========================");
        //输出already_arr
        for(int i : visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : prevertex) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();

    }
}