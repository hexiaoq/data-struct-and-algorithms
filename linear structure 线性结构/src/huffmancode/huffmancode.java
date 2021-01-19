package huffmancode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class huffmancode {
    /**字符压缩和还原
    public static void main(String[] args) {
        String context = "i like like like java do you like a java";
        byte[] bytes = context.getBytes();
        System.out.println(Arrays.toString(bytes));
//        System.out.println(getNodes(bytes));
//         Node node = createhuffman(getNodes(bytes));
//gethuffmancode(node,"",s);
//        byte[] zip = zip(bytes, huffmanmap);
//        System.out.println(Arrays.toString(zip));
        byte[] hufmanzip = hufmanzip(context.getBytes());

        byte[] ziptohufmancode = ziptohufmancode(huffmanmap, hufmanzip);
        System.out.println(Arrays.toString(ziptohufmancode));
        System.out.println(new String(bytes));
    }
     **/
    /**
     * 图片压缩和还原
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BufferedInputStream is=new BufferedInputStream(new FileInputStream("war.txt"));
        byte[] bytes=new byte[is.available()];
        is.read(bytes);
        byte[] hufmanzip = hufmanzip(bytes);
        System.out.println(Arrays.toString(hufmanzip));
        System.out.println(hufmanzip.length);
        byte[] ziptohufmancode = ziptohufmancode(huffmanmap, hufmanzip);
        BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream("war1.txt"));
        os.write(ziptohufmancode);
        is.close();
        os.close();

    }

    /**
     * 使用一个方法将得到哈夫曼字节数组的过程封装起来
     * @param bytes 字符串的字节数组
     * @return 压缩后的哈夫曼字节数组
     */
    public static byte[] hufmanzip(byte[] bytes)
    {//创建哈夫曼编码树
        Node node = createhuffman(getNodes(bytes));

        //获得储存字符对应的哈夫曼编码的map
        gethuffmancode(node,"",s);

        //获得压缩后的哈夫曼字节数组
        byte[] zip = zip(bytes, huffmanmap);
        return zip;

    }
    //得到,由字符串getbytes得到的字节数组
    public static byte[] ziptohufmancode(Map<Byte,String> huffmanmap,byte[] huffmanbytes)
    {StringBuilder s=new StringBuilder();
    boolean flag=true;
        for (int i = 0; i < huffmanbytes.length; i++) {
            if(i==huffmanbytes.length-1)
            {flag=false;
            }

                s.append(bytetostring(flag,huffmanbytes[i]));
        }
        Map<String,Byte> map=new HashMap<>();
        List<Byte> list=new ArrayList<>();
        for(Map.Entry<Byte,String> m:huffmanmap.entrySet())
        {map.put(m.getValue(),m.getKey());
        }
        for (int i = 0; i <s.length() ;) {
            int count=1;
            boolean flag1=true;
            Byte aByte=null;
            while (flag1)
            {
                String s1;

                s1=s.substring(i,i+count);
             aByte = map.get(s1);
                if(aByte==null)
                {
                    count++;
                }
                else {
                    flag1=false;
                }

            }
            i+=count;
            list.add(aByte);

        }
        byte[] bytes=new byte[list.size()];int i=0;
        for (Byte aByte : list) {
            bytes[i]=aByte;
            i++;
        }
        return bytes;

    }

    public static String bytetostring(boolean flag,Byte b)
    {int i=b;
    //如果不是最后一个字节,则要补符号位,并取string的最后的八位
    if(flag)
    {
        i=256|i;
    }

        String s = Integer.toBinaryString(i);
    if(flag) {
        String substring = s.substring(s.length() - 8, s.length());

    return substring;}
    else
    return s;}


//    得到压缩后的哈夫曼字节数组
    public static byte[] zip(byte[] bytes,Map<Byte,String> map)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for(byte b:bytes)
        {

            stringBuilder.append(map.get(b));
        }
        //1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
//        System.out.println(stringBuilder);
        //  求该字符串可以分为几个字节
        int len=(stringBuilder.length()+7)/8;
        byte[] bytes1=new byte[len];
        int index=0;
        for (int i = 0; i <stringBuilder.length() ; i=8+i) {
            if(i+8>stringBuilder.length())
            {
                bytes1[index]=(byte)Integer.parseInt(stringBuilder.substring(i),2);
            }
            else{
                bytes1[index]=(byte)Integer.parseInt(stringBuilder.substring(i,i+8),2);

            }
            index++;

        }
        return bytes1 ;
    }


    static Map<Byte,String> huffmanmap=new HashMap<>();
    static StringBuilder s=new StringBuilder();
    //借助哈夫曼树,获得各字符对应的哈夫曼编码
    public static void gethuffmancode(Node node,String sr,StringBuilder s)
    {
        StringBuilder s2=new StringBuilder(s);
        s2.append(sr);
//        if(node!=null) {
            if (node.value == null) {
                gethuffmancode(node.left, "0", s2);
                gethuffmancode(node.right, "1", s2);
            } else {
                huffmanmap.put(node.value,s2.toString());
            }
        }
//        }


//将字节数组转化为node数组
    public static List<Node> getNodes(byte[] bytes) {
        List<Node> list = new ArrayList<Node>();
        Map<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
           Integer counts =map.get(bytes[i]);
            if (map.get(bytes[i]) == null) {
                map.put(bytes[i], 1);
            } else {
                map.put(bytes[i], ++counts);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node=new Node(entry.getKey(), entry.getValue());
            list.add(node);
        }
        return list;
    }

    //建立哈夫曼树,哈夫曼树可以帮助获得每个字符对应的哈夫曼编码
        public static Node createhuffman(List<Node> tree)
    {


        while(tree.size()>1)
        {

            Collections.sort(tree);

           Node node=new Node(null,tree.get(0).weight+tree.get(1).weight);
            tree.add(node);
            node.left=tree.get(0);
            node.right=tree.get(1);
            tree.remove(0);
            tree.remove(0);

        }



        return tree.get(0);
    }


}
    class Node implements Comparable<Node> {
        public Byte value;
        public Integer weight;
        public Node left;
        public Node right;

        public Node(Byte value, Integer weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {

            return "Node{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        public void frontshow() {
            System.out.println(this.value+"   "+weight);
            if (this.left != null) {
                this.left.frontshow();
            }
            if (this.right != null) {
                this.right.frontshow();
            }


        }
    }

