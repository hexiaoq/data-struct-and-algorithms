package kmp;

public class Viloncematch {
    public static void main(String[] args) {
        System.out.println(viloncematch("我喜欢看电影我喜欢敲代码","我喜欢敲代码"));


    }
    public static int viloncematch(String s1,String s2)
    {
        char[] c1=s1.toCharArray() ;
        char[] c2=s2.toCharArray();

        for (int i=0,j = 0; i < c1.length&&j<c2.length; i++,j++) {
            if(!(c1[i] ==c2[j]))
            {
                //从开始位置的下一个位置重新匹配,由于for循环中i,j会加1所以此处均减1
                i=i-j;
                j=-1;
            }
            if(j==c2.length-1)
            {
                return i-j;
            }

        }
        return -1;
    }
}
