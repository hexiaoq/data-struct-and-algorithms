package queue;

import java.util.Scanner;

public class arrayqueue1 {
    //队列容量
    private int maxsize;
    //指向头部前一个的输出指针
    private int front;
    //指向尾部最后一个数据的输入指针
    private int rear;
    //实现队列的数组
    private int[] arr;

    public arrayqueue1(int maxsize) {
        this.maxsize = maxsize;
        arr=new int[maxsize];
        front=-1;
        rear=-1;

    }
    public boolean isempty(){
        return front==rear;

    }
    public boolean isfull()
    {
        return rear==maxsize-1;
    }
    public void  additem(int n)
    {
        if(isfull())
        {
            throw new RuntimeException("队列已满,不能添加数据");
        }
        else
        {
            rear++;
            arr[rear]=n;
        }
    }
    public int fetchitem()
    {
        if(isempty())
        {
            throw new  RuntimeException("队列为空,无法取出数据");

        }
        else{
            return arr[++front];

        }
    }
    //显示头部数据(最后一个进入的数据)
    public int showhead()
    {
        if(isempty())
        {
            throw new  RuntimeException("队列为空,无头部数据");

        }
        else{
            int a=front+1;
            return arr[a];

        }

    }
    public void showall()
    {
        if(isempty())
        {
            throw new  RuntimeException("队列为空,无数据");

        }
        else{
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");

            }

        }

    }

    public static void main(String[] args) {
        arrayqueue1 queue = new arrayqueue1(3);
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
