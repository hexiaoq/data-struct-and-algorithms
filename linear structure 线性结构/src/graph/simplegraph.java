package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class simplegraph {
    private List<String> vertexs;
    private int[][] edges;
    private int n;
    public boolean[] visited;
    public simplegraph(int n) {
        this.n = n;
        vertexs=new ArrayList<>(n);
        edges=new int[n][n];
        visited=new boolean[n];
    }


    public static void main(String[] args) {
        simplegraph graph=new simplegraph(8);
      String[] v={"1","2","3","4","5","6","7","8"};
//        graph.addedgess(0,1,1);
//        graph.addedgess(0,2,1);
//        graph.addedgess(1,2,1);
//        graph.addedgess(1,3,1);
//        graph.addedgess(1,4,1);
        for (int i = 0; i < v.length; i++) {
            graph.addvertex(v[i]);
        }
        graph.addedgess(0, 1, 1);
        graph.addedgess(0, 2, 1);
        graph.addedgess(1,3, 1);
        graph.addedgess(1, 4, 1);
        graph.addedgess(3, 7, 1);
        graph.addedgess(4, 7, 1);
        graph.addedgess(2, 5, 1);
        graph.addedgess(2, 6, 1);
        graph.addedgess(5, 6, 1);

        graph.show();
graph.dfs(0);

    }
    //得到第一个邻接节点
    public int getfirstNeighbor(int index)
    {
        for (int i = 0; i < edges.length; i++) {
            if(edges[index][i]>0)
            {return i;

            }

        }
        return -1;
    }

    /**
     * //得到pre邻接节点的下一个邻接节点
     * @param index 该节点
     * @param pre  该节点的一个邻接节点
     * @return pre后的下一个邻接节点的索引
     */
    public int getnextNeighbor(int index,int pre)
    {
        for (int i = pre+1; i < edges.length; i++) {
            if(edges[index][i]>0)
            {return i;

            }

        }
        return -1;
    }

    public void dfs(int index)
    {
        visited[index]=true;
        System.out.println(vertexs.get(index));
        int next=getfirstNeighbor(index);
        while (next!=-1)
        {
            if(!visited[next])
            { dfs(next);}

            next=getnextNeighbor(index,next);
        }


    }
//    public void dfs()
//    {
//        for (int i = 0; i < vertexs.size(); i++) {
//            if(visited[i]!=true)
//                dfs(i);
//
//        }
//    }



    public void addvertex(String v)
    {
        vertexs.add(v);
    }

    /**
     * 给相连的定点添加边
     * @param v1 顶点的值
     * @param v2 顶点的值
     * @param weight 权重 即相连为1
     */
    public void addedgess(int v1,int  v2,int weight)
    {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;

    }
    public void show()
    {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }

    }

}
