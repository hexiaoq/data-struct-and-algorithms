package Tree;


import java.util.ArrayList;
import java.util.List;

public class binarytreedemo {
    public static void main(String[] args) {
        heronode heronode1 = new heronode(1, "宋江");
        heronode heronode2 = new heronode(2, "卢俊义");
        heronode heronode3 = new heronode(3, "吴用");
        heronode heronode4 = new heronode(4, "武松");
        heronode3.setLeft(heronode2);
        heronode3.setRight(heronode4);
        heronode2.setLeft(heronode1);
        heronode1.frontshow(heronode3);
       heronode3.deletebyid(2);
       heronode1.frontshow(heronode3);


    }
}

class binarytree {
    private heronode root;

    public binarytree() {
    }

    public heronode getRoot() {
        return root;
    }

    public void setRoot(heronode root) {
        this.root = root;
    }

    public binarytree(heronode root) {
        this.root = root;
    }
}

class heronode {
    private int id;
    private String name;
    private heronode left;
    private heronode right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public heronode getLeft() {
        return left;
    }

    public void setLeft(heronode left) {
        this.left = left;
    }

    public heronode getRight() {
        return right;
    }

    public void setRight(heronode right) {
        this.right = right;
    }

    public heronode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "heronode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //
    public void frontshow(heronode root) {

        System.out.println(root);
        if (root.left != null) {
            frontshow(root.left);
        }
        if (root.right != null) {
            frontshow(root.right);
        }
    }

    public void midshow(heronode root) {

        if (root.left != null) {
            frontshow(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            frontshow(root.right);
        }
    }

    public void backshow(heronode root) {
        if (root.left != null) {
            frontshow(root.left);
        }
        if (root.right != null) {
            frontshow(root.right);
        }
        System.out.println(root);

    }
    public void deletebyid(int no)
    {
        if(this.left!=null&&this.left.id==no)
        {
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.id==no)
        {
            this.right=null;
            return;
        }
        if (this.left != null) {
            this.left.deletebyid(no);
        }

        if (this.right != null) {
            this.right.deletebyid(no);

        }

    }

    //找到就返回不找到就不返回的递归,可以如下定义一个tem,根据tem是否为空判断是否返回
    public heronode frontfind(int no) {

        if (this.id == no) {
            return this;

        }
        heronode tem = null;
        if (this.left != null) {
            tem = this.left.frontfind(no);
        }
        if (tem != null) {
            return tem;
        }
        if (this.right != null) {
            tem = this.right.frontfind(no);

        }
        return tem;
//平衡二叉树的查找方法
//    if(this.id==no)
//    {return this;
//
//    }
//    if(this.id>no&&this.left!=null)
//    {
//        return this.left.frontfind(no);
//    }
//    else if(this.id<no&&this.right!=null)
//    {
//       return this.right.frontfind(no);
//    }
//    else return null;


    }

    public heronode midfind(int no) {


        heronode tem = null;
        if (this.left != null) {
            tem = this.left.midfind(no);
        }
        if (tem != null) {
            return tem;
        }
        if (this.id == no) {
            return this;

        }
        if (this.right != null) {
            tem = this.right.midfind(no);

        }
        return tem;


    }
}
