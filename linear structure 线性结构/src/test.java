import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args) {
        int b=1;
        b=b|256;
        System.out.println(b);
        String s = Integer.toBinaryString(b);
        System.out.println(s);

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(3,6);
        System.out.println(map.put(3,4));

        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey()+"    "+entry.getValue());
        }
//        BiConsumer<Integer,Integer> action=new BiConsumer<Integer, Integer>() {
//            @Override
//            public void accept(Integer integer, Integer integer2) {
//
//            }
//        }
//        map.forEach();

    }
}
