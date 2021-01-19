package hashtable;

public class hashtabledemo {
    public static void main(String[] args) {
        hashtable table=new hashtable(5);
        for (int i = 0; i <20; i++) {
           table.add( new emp(i,"何小强员工"+i+"号"));

        }
        table.show();
    }
}
class hashtable{
    linklist[] array;
    int size;

    public hashtable(int size) {
        this.array =new linklist[size];
        this.size = size;
        //一定别忘了初始化每条链表,null是不可以增加节点的
        for (int i = 0; i <size ; i++) {
            array[i]=new linklist();
        }
    }
    public int hashcode(int id)
    {
        int hashcode=id%size;
        return hashcode;
    }
    public void  add(emp emp)
    {
        int hashcode=hashcode(emp.id);
        array[hashcode].add(emp);

    }
    public void show ()
    {
        for (int i = 0; i <size ; i++) {
            System.out.println("第"+i+"条链表的员工id");
            array[i].show();
        }
    }

}
class emp{
    public int id;
    public String name;
    public emp next;

    public emp() {
    }

    public emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class linklist{
    emp head=null;
    emp back=null;
    public void add(emp emp)
    {
        if(head==null)
        {
            head=emp;
            back=emp;
        }
        else{
            back.next=emp;
            back=emp;
        }
    }
    public void show()
    {emp tem=head;
        if(head==null)
            System.out.println("空链表");
        else
            while(tem.next!=null) {
                System.out.println(tem.id);
                tem = tem.next;
            }

    }

}
