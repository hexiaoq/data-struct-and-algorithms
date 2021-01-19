package queue;

import java.util.Scanner;

/**
 * 环形数组解决数组队列不可复用问题
 * 不可越界版,所有可能越界的下标都做模运算
 */
public class arrayqueue3 {
    //队列容量
    private int maxsize;
    //指向第一个数据的输出指针
    private int front;
    //指向最后一个数据下一个的输入指针
    private int rear;
    //实现队列的数组
    private int[] arr;

    public arrayqueue3(int maxsize) {
        this.maxsize = maxsize;
        arr=new int[maxsize];
        front=0;
        rear=0;

    }
    public boolean isempty(){
        return front==rear;

    }
    public boolean isfull()
    {
        return (rear+1)%maxsize==front;
    }
    public void  additem(int n)
    {
        if(isfull())
        {
            throw new RuntimeException("队列已满,不能添加数据");
        }
        else
        {

            arr[rear]=n;
            rear=(rear+1)%maxsize;

        }
    }
    public int fetchitem()
    {
        if(isempty())
        {
            throw new  RuntimeException("队列为空,无法取出数据");

        }
        else{
            int a=arr[front];
            front=(front+1)%maxsize;
            return a;


        }
    }
    //显示头部数据(第一个进入的数据)
    public int showhead()
    {
        if(isempty())
        {
            throw new  RuntimeException("队列为空,无头部数据");

        }
        else{
            int a=front;
            return arr[a];

        }

    }
    //队列中得有效数据
    public int size(){
        //防止出现负数,rear比front小的情况下数据为rear下的和front上得,rear比front大的情况下数据为rear和front之间的
        return (rear+maxsize-front)%maxsize;
    }
    public void showall()
    {
        if(isempty())
        {
            throw new  RuntimeException("队列为空,无数据");

        }
        else{
            for (int i = front; i <front+size(); i++) {
                System.out.print(arr[i%maxsize]+"");
                if(i==size()-1)
                {
                    System.out.println();
                }

            }

        }

    }

    public static void main(String[] args) {
        arrayqueue3 queue = new arrayqueue3(3);
        boolean loop=true;
        Scanner scanner=new Scanner(System.in)
                ;
        while(loop)
        {
            System.out.println("1.显示队列");
            System.out.println("2.显示头部数据");
            System.out.println("3.添加数据");
            System.out.println("4.删除数据");
            System.out.println("5.退出程序");
            int value=scanner.nextInt();

            switch (value)
            {
                case 1:
                    try {
                        queue.showall();
                    } catch (Exception e) {
                        System.out.println("队列为空,无数据");
                    }
                    break;
                case 2:
                    try {
                        System.out.println(queue.showhead());
                    } catch (Exception e) {
                        System.out.println("队列为空,无法取出数据");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("请输入你要添加的数据");
                        int a=scanner.nextInt();
                        queue.additem(a);
                    } catch (Exception e) {
                        System.out.println("队列已满,无法添加数据");
                    }
                    break;
                case 4:
                    try {
                        int data = queue.fetchitem();
                        System.out.println("取出的数据是"+data);
                    } catch (Exception e) {
                        System.out.println("队列为空,无法取出数据");
                    }
                    break;
                case 5:
                    scanner.close();
                    loop=false;
            }
        }
        System.out.println("退出程序");



    }
}
