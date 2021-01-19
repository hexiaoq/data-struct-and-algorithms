package linklist;

/**
 * 环形单链表,解决约瑟夫问题
 * 有N个小孩围成一圈，给他们从1开始依次编号，现指定从第W个开始报数，报到第S个时，该小孩出列，然后从下一个小孩开始报数，
 * 仍是报到S个出列，如此重复下去，直到所有的小孩都出列（总人数不足S个时将循环报数），求小孩出列的顺序。
 */

public class circlesinglelingklistdemo {
    public static void main(String[] args) {
        circlesingleingklist list=new circlesingleingklist();
        list.sovlejospen(2,4,100);

    }
}
//无头节点版
class circlesingleingklist{
    kid first=null;

    /**
     *使用双指针,一个为first,另一个指向最后一个,二者同步移动,使first一直指向要出列的小孩
     * @param startnum 开始数的小孩
     * @param outnum 出列的数字
     * @param num 小孩总数
     */
    public void sovlejospen(int startnum,int outnum,int num)
    { addkid(num);
    //让help指向最后一个节点
        kid help=first;
        while(help.next!=first)
        {help=help.next;

        }
        //让两个指针移动到startnum处
        for (int i = 0; i <startnum-1 ; i++) {
            first=first.next;
            help=help.next;
        }
        //出圈操作
        while(first.next!=first) {
            for (int i = 0; i < outnum - 1; i++) {
                first = first.next;
                help = help.next;
            }
            System.out.printf("第%d个孩子出列\n", first.num);
            help.next = first.next;
            first = first.next;
        }
        System.out.printf("第%d个孩子出列\n", first.num);

    }
    public void addkid(int num)
    {
        if(num<1)
        {
            System.out.println("你输入的数字不合理");
            return;
        }
        kid tem=null;
        for (int i = 1; i <=num ; i++) {
            kid kid=new kid(i);
            if(i==1)
            {//first必须一直指向第一个kid
                first=kid;
                //tem代替first进行移动
               tem=first;
                first.next=first;
            }
            tem.next=kid;
            tem=kid;
            kid.next=first;

        }
    }
    public void outkid(int no)
    { kid tem=first;
    //排除头结点的情况
        if(first.num==no)
        {    while (tem.next!=first)
        {
            System.out.println(tem.num+"出列");
            tem=tem.next;

        }
        //找到最后一个节点,使其指向第二个节点
        tem.next=first.next;
        //使第二个节点成为第一个节点
        first=first.next;
        }
        while(tem.next!=first)
        {if(tem.next.num==no)
        {
            System.out.println(tem.next.num+"出列");
            tem.next=tem.next.next;
            break;
        }
        tem=tem.next;


        }
    }

    public  void showall()
    {kid tem=first.next;
        System.out.println(first.num);
        while (tem!=first)
    {
        System.out.println(tem.num);
        tem=tem.next;

    }

    }

}
class kid{
    public  int num;
    public kid next;

    public kid(int num) {
        this.num = num;
    }
}

