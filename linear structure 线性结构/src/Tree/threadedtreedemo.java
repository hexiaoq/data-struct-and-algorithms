package Tree;
//线索化二叉树
public class threadedtreedemo
{
    public static void main(String[] args) {
        node heronode1 = new node(1, "宋江");
        node heronode2 = new node(2, "卢俊义");
        node heronode3 = new node(3, "吴用");
        node heronode4 = new node(4, "武松");
        heronode3.setLeft(heronode2);
        heronode3.setRight(heronode4);
        heronode2.setLeft(heronode1);
        threadedtree tree=new threadedtree();
        tree.threaded(heronode3);
        System.out.println(heronode2.getRight()+"---->"+heronode2.getRighttype());
        heronode3.frontshow(heronode3);
    }

}
class threadedtree {
//前驱结点
    private node pre;


    public void threaded(node root)
    { //线索化左子树
        if(root.getLeft()!=null)
    {
        threaded(root.getLeft());
    }
//线索化当前节点

      if(root.getLeft()==null)
      {
          root.setLeft(pre);
      root.setLefttype(1);
      }
//使前前驱节点的后继节点指向自己
      if(null!=pre&&pre.getRight()==null)
      {
          pre.setRight(root);
          pre.setRighttype(1);
      }
        //说明:第一个节点肯定是没有前驱结点的,所以pre声明后不需要初始化,为null即可,等第一个结点线索化完,
        //第二个节点的前驱节点即为第一个节点
      pre=root;

      //线索化右子树
        if(root.getRight()!=null)
        {
            threaded(root.getRight());
        }

    }
}
class node {
    private int id;
    private String name;
    private node left;
    private node right;
    //如果lefttype=0,则left指向左子树,1则指向前驱结点
    private int lefttype;
    private int righttype;

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

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    public node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //
    public void frontshow(node root) {
        System.out.println(root);
        if (root.left != null&&root.lefttype==0) {
            frontshow(root.left);
        }
        if (root.right != null&&root.righttype==0) {
            frontshow(root.right);
        }
    }

    public void midshow(node root) {

        if (root.left != null) {
            frontshow(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            frontshow(root.right);
        }
    }

    public void backshow(node root) {
        if (root.left != null) {
            frontshow(root.left);
        }
        if (root.right != null) {
            frontshow(root.right);
        }
        System.out.println(root);

    }

    public void deletebyid(int no) {
        if (this.left != null && this.left.id == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == no) {
            this.right = null;
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
    public node frontfind(int no) {

        if (this.id == no) {
            return this;

        }
        node tem = null;
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


    }

    public node midfind(int no) {


        node tem = null;
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

    public int getLefttype() {
        return lefttype;
    }

    public void setLefttype(int lefttype) {
        this.lefttype = lefttype;
    }

    public int getRighttype() {
        return righttype;
    }

    public void setRighttype(int righttype) {
        this.righttype = righttype;
    }
}
