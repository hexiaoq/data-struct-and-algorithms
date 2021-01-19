package linklist;

public class doublelinklistdemo {
    public static void main(String[] args) {

    }
}
class doublelinklist
{

}
class hero2 {
    public int no;
    public String name;
    public String nickname;
    public hero2 next;
    //双向链表增加一个指向后面的指针
    public hero2 pre;

    public hero2(int no, String name, String nickname) {
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
