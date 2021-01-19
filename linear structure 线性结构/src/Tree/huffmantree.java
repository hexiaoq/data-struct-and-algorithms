package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class huffmantree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node createhuffman = createhuffman(arr);
        System.out.println(createhuffman);
        createhuffman.frontshow();
    }
    public static Node createhuffman(int[] arr)
    {
        List<Node> tree=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }

        while(tree.size()>1)
        {

            Collections.sort(tree);

            Node node=new Node(tree.get(0).value+tree.get(1).value);
           tree.add(node);
           node.left=tree.get(0);
           node.right=tree.get(1);
            tree.remove(0);
            tree.remove(0);

            System.out.println(tree);
        }



        return tree.get(0);
    }


}
class Node implements Comparable<Node>{
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
    public void frontshow()
    {
        System.out.println(this.value);
        if(this.left!=null)
        {
            this.left.frontshow();
        }
        if(this.right!=null)
        {
            this.right.frontshow();
        }



    }

}
