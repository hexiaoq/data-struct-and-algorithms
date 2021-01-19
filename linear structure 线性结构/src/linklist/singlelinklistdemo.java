package linklist;

import java.util.Scanner;

public class singlelinklistdemo {
    public static void main(String[] args) {
        linklist list = new linklist();
//        list.addlist(new hero(1,"宋江","及时雨"));
//        list.addlist(new hero(2,"卢俊义","玉麒麟"));
//        list.addlist(new hero(3,"吴用","智多星"));
//        list.addlist(new hero(4,"武松","打虎英雄"));
        list.addbyorder(new hero(1, "宋江", "及时雨"));
        list.addbyorder(new hero(4, "武松", "打虎英雄"));
        list.addbyorder(new hero(3, "吴用", "智多星"));
        list.addbyorder(new hero(2, "卢俊义", "玉麒麟"));

        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while(loop) {
            System.out.println("1.展示所有英雄");
            System.out.println("2.修改英雄信息");
            System.out.println("3.反转链表并显示");
            System.out.println("4.添加英雄信息");
            System.out.println("5.删除英雄信息");
            System.out.println("0.退出程序");

            int value = scanner.nextInt();

            switch (value) {
                case 1:
                    list.showlist();
                    break;
                case 2:
                    System.out.println("请输入编号:");
                    int no=scanner.nextInt();
                    System.out.println("请输入名字");
                    String name=scanner.next();
                    System.out.println("请输入外号");
                    String nickname=scanner.next();
                    hero update=new hero(no,name,nickname);
                    list.update(update);
                    break;
                case 3:
                    list.Reverse();
                    list.showlist();

                    break;
                case 4:
                    System.out.println("请输入编号:");
                    int no1=scanner.nextInt();
                    System.out.println("请输入名字");
                    String name1=scanner.next();
                    System.out.println("请输入外号");
                    String nickname1=scanner.next();
                    hero add=new hero(no1,name1,nickname1);
                    list.addbyorder(add);

                    break;
                case 5:
                    System.out.println("请输入编号");
                    int num=scanner.nextInt();
                    list.delete(num);
                    break;
                case 0:
                    loop=false;
                    break;
            }
        }



}}

class linklist {
    private hero head = new hero(0, "", "");



    public void delete(int no)
    {
        //排除空链表的情况
        if(head.next==null)
        {
            System.out.println("空链表,无法删除");
            return;
        }
        hero tem=head;
        while (true)
        {if(tem.next==null)
        {
            System.out.println("没有该英雄");
            break;
        }
            if(tem.next.no==no)
        {
            hero help=tem.next;
            tem.next=help.next;
            return;
        }
            else
                tem=tem.next;


        }


    }
    //在尾部添加节点
    public void addlist(hero hero) {
        hero tem = head;
        //令tem等于最后一个节点
        while (true) {
            if (tem.next == null) {
                break;
            } else
                tem = tem.next;
        }
        tem.next = hero;


    }

    //遍历每个节点
    public void showlist() {
        hero tem = head.next;
        while (true) {
            if (tem.next == null) {
                System.out.println(tem);
                break;
            } else {
                System.out.println(tem);
                tem = tem.next;
            }
        }

    }

    public void addbyorder(hero hero) {
        hero tem = head;
        //判断是否重复编号
        boolean flag = false;
        while (true) {
            //如果以下两个条件都不满足则直接在最后面插入
            if (tem.next == null) {
                break;
            }
            if (tem.next.no == hero.no) {
                flag = true;
                break;

            }
            //满足此条件,说明找到了对应的位置
            else if (tem.next.no > hero.no) {
                break;
            }
            tem = tem.next;
        }
        if (flag) {
            System.out.println("你添加的英雄已经存在");
        } else {
            hero.next = tem.next;
            tem.next = hero;
        }
    }

    public void update(hero hero) {
        hero tem = head;
        boolean flag = false;
        while (true) {
            if (tem.next == null) {
                flag = true;
                break;

            }
            if (tem.next.no == hero.no) {
                break;
            }
            tem = tem.next;

        }
        if (!flag) {
            hero.next = tem.next.next;
            tem.next = hero;
        } else {
            System.out.println("你所要修改的英雄不存在");
        }

    }

    //反转链表,先从头到尾遍历每个节点,同时再使用头插法插入新链表
    public void Reverse() {
        //排除无法反转的情况
        if(this.head.next.next==null||this.head.next==null)
        {
            System.out.println("链表为空或者数据为1,无法反转");
            return;
        }
        hero tem = this.head.next;
        hero retem = new hero(0,"","");
        hero help=null;
        while (tem!=null) {
            //保存tem.next
            help=tem.next;
            tem.next=retem.next;
            retem.next = tem;
            tem =help;

        }
        this.head.next=retem.next;


    }

}

class hero {
    public int no;
    public String name;
    public String nickname;
    public hero next;

    public hero(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
