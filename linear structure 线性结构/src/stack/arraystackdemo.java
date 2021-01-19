package stack;

public class arraystackdemo {
    public static void main(String[] args) {
        arraystack stack = new arraystack(4);
   stack.outstack();

    }
}

class arraystack {
    public int maxsize;
    //有数据时,一直指向栈顶的元素
    public int top = -1;
    public int[] arr;

    public arraystack(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
    }

    //栈满
    public boolean isfull() {
        return (top == maxsize - 1);

    }

    //栈为空
    public boolean isempty() {
        return (top == -1);

    }

    //出栈
    public int outstack() {
        if (isempty()) {
            System.out.println("栈为空,无法输出数据");
            return -1;
        }
        System.out.println("出栈数为" + arr[top]);
        int i = arr[top];
        top--;
        return i;
    }

    //入栈
    public void add(int num) {
        if (isfull()) {
            System.out.println("栈已满,无法添加数据");
            return;

        }
        arr[++top] = num;


    }
    public void showall()
    {
        for (int i = 0; i <maxsize ; i++) {
            System.out.println(arr[i]);

        }
    }
}
