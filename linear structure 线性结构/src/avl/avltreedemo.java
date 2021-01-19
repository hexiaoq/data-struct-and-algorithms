package avl;

public class avltreedemo {
    public static void main(String[] args) {
        int[] arr={10,7,11,6,8,9};
        avltree tree=new avltree();
        for (int i = 0; i <arr.length; i++) {
            tree.addnode(new node(arr[i]));

        }
        tree.midshow();
        System.out.println(tree.getRoot().height());
    System.out.println(tree.getRoot().leftheight());
    System.out.println(tree.getRoot().rightheight());
        System.out.println(tree.getRoot().getValue());

    }
}
class avltree{
    private node root;

    public node getRoot() {
        return root;
    }

    /**
     * 删除以node节点为根节点的二叉树排序树的最小值节点,并返回这个节点值valu
     * @param node
     * @return 最小节点的值
     */
    public int deltreemin(node node)
    {
        node tem=node;
        while(tem.getLeftnode()!=null)
        {tem=tem.getLeftnode();

        }
        deletenode(tem.getValue());
        return tem.getValue();

    }
    //删除节点
    public void deletenode(int value)
    {
        node n=searchvalue(value);
        node parent=searchparent(value);
        if(n==null)
        {
            return;
        }
        //父节点为空,则一定为根节点
        if(parent==null)
        {root=null;
            return;
        }
        //该节点是叶子节点
        if(n.getLeftnode()==null&&n.getRightnode()==null)
        {

            if(parent.getRightnode()!=null&&parent.getRightnode()==n)
                parent.setRightnode(null);
            else parent.setLeftnode(null);
        }
        //有两个子树得节点
        else if(n.getLeftnode()!=null&&n.getRightnode()!=null)
        {//找到右子树的最小值,删除最小节点,并将自己的值改为最小节点的值即可
            int i=deltreemin(n.getRightnode());
            n.setValue(i);

        }
        //有一个子树得节点
        else{
            //如国左子树为空
            if(n.getLeftnode()!=null)
            {
                if(parent.getLeftnode()!=null&&parent.getLeftnode()==n)
                {
                    parent.setLeftnode(n.getLeftnode());
                }
                else
                    parent.setRightnode(n.getLeftnode());
            }
            //如果右子树为空
            else if(n.getRightnode()!=null)
            {
                if(parent.getLeftnode()!=null&&parent.getLeftnode()==n)
                {
                    parent.setLeftnode(n.getRightnode());

                }
                else
                    parent.setRightnode(n.getRightnode());
            }

        }
    }

    public void addnode(node node)
    {
        if (root==null)
        {
            root=node;
        }
        else{
            root.addnode(node);
        }
    }
    public void midshow()
    {
        if(root==null)
            System.out.println("空树,无法遍历");
        else
            root.midshow();
    }
    public node searchvalue(int value)
    {
        if(root==null)
        {
            System.out.println("空树");
            return null;
        }
        else return root.searchvalue(value);
    }
    public node searchparent(int value){
        if(root==null)
        {
            System.out.println("空树");
            return null;
        }
        else return root.searchparent(value);

    }
}

class node {
    private int value;
    private node leftnode;
    private node rightnode;

    public node getLeftnode() {
        return leftnode;
    }

    public void setLeftnode(node leftnode) {
        this.leftnode = leftnode;
    }

    public node getRightnode() {
        return rightnode;
    }

    public void setRightnode(node rightnode) {
        this.rightnode = rightnode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public node(int value) {
        this.value = value;
    }
    //查找指定value值得节点
    public node searchvalue(int value)
    {
        if(this.value==value)
            return this;
        else
        {
            if(this.value>value&&this.leftnode!=null)
            {
                return this.leftnode.searchvalue(value);
            }
            else if(this.value<=value)
            {
                return this.rightnode.searchvalue(value);
            }
            else
                return null;
        }
    }
    //查找指定value值的父节点
    public node searchparent(int value)
    {
        if((this.leftnode!=null&&this.leftnode.value==value)||(this.rightnode!=null&&this.rightnode.value==value))
            return this;
        else{
            if(value<this.value&&this.leftnode!=null)
            {
                return this.leftnode.searchparent(value);
            }
            else if(value>=this.value&&this.rightnode!=null)
            {
                return this.rightnode.searchparent(value);
            }
            else
                //没有找到父节点
                return null;
        }
    }
    //添加子节点
    public void addnode(node node) {
        if (this.value > node.value) {
            if (this.leftnode == null) {
                this.leftnode = node;
            } else
                this.leftnode.addnode(node);
        } else {
            if (this.rightnode == null) {
                this.rightnode = node;

            } else {
                this.rightnode.addnode(node);
            }
        }
        //左旋转情况
        if (rightheight()-leftheight()>1) {
            //右节点的左子树不能大于右子树的高度
if(rightnode!=null&&rightnode.leftheight()>rightnode.rightheight())
{
    rightnode.rightrotate();
    leftrotate();
}
          else  leftrotate();
        }
        //右旋转情况
        else if (leftheight() - rightheight() > 1)
        {//右旋转时左节点的右子树不能大于左子树的高度
            if(leftnode!=null&&leftnode.leftheight()<leftnode.rightheight())
        {
            leftnode.leftrotate();
            rightrotate();
        }
            else rightrotate();}
    }
    //中序遍历
    public void midshow() {
        if (this.leftnode != null) {
            this.leftnode.midshow();
        }
        System.out.println(this.value);
        if (this.rightnode != null)
        {
            this.rightnode.midshow();
        }
    }
    public int leftheight()
    {
        if(leftnode!=null)
            return leftnode.height();
        else
            return 0;
    }
    public int rightheight()
    {
        if(rightnode!=null)
            return rightnode.height();
        else
            return 0;
    }
    //返回该avl树的高度
    public int height()
    {
        return Math.max(leftnode==null?0:leftnode.height(),rightnode==null?0:rightnode.height())+1;
    }
    //左旋转
    public void leftrotate()
    {node newnode=new node(this.value);
    newnode.leftnode=this.leftnode;
    newnode.rightnode=rightnode.leftnode;
    this.value=rightnode.value;
    rightnode=rightnode.rightnode;
    leftnode=newnode;

    }
    //右旋转
    public void rightrotate()
    {
        node newnode=new node(this.value);
        newnode.rightnode=rightnode;
        newnode.leftnode=leftnode.rightnode;
        this.value=leftnode.value;
        leftnode=leftnode.leftnode;
        rightnode=newnode;
    }

}

