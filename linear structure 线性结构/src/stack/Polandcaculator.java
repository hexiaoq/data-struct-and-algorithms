package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现后缀表达式的计算器
 */
public class Polandcaculator {
    public static void main(String[] args) {
        //要求输入的后缀表达式的字符之间必须用空格隔开,便于分离然后存入数组
        //(30+4)*5-3  30 4 + 5 * 3 -
//        String poland="30 4 + 5 * 3 -";
//
//        List<String> list=tolist(poland);
//        int caculator = caculator(list);
//        System.out.println(poland+"的计算结果是:"+caculator);
        String poland = "300/(5*(13-3))+6";
        System.out.println("aaaa");

        System.out.println(tomid(poland));
        List<String> midtoback = midtoback(tomid(poland));
        System.out.println(midtoback);
        System.out.println(caculator(midtoback));

    }

    public static List<String> midtoback(List<String> mid) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (String s : mid) {
            //数字直接进站
            if (s.matches("\\d+")) {
                list.add(s);
            } else if (s.equals("("))
                stack.push(s);
            else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                //把左括号也弹出
                stack.pop();
            } else {
                if(stack.size()>0&&getoper(s)<getoper(stack.peek()))
                {
                    list.add(stack.pop());
                }
                stack.push(s);

            }
        }
        //将栈中剩余的符号添加到list中
        while(stack.size()!=0)
        {
            list.add(stack.pop());
        }
        return list;

    }

    //将不带空格的字符串转换成中缀表达式
    public static List<String> tomid(String poland) {
        List<String> list = new ArrayList<>();
        char[] chars = poland.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //非数字
            if (chars[i] < 48 || chars[i] > 57) {
                list.add(chars[i] + "");

            }
            //处理多位数字
            if (chars[i] >= 48 && chars[i] <= 57) {
                String sr = chars[i] + "";
                i++;
                if (i < chars.length) {
                    //判断下一位是否还是数字,即判断是否是多位数
                    while (true) {
                        //如果是加上并继续判断下一位
                        if (chars[i] >= 48 && chars[i] <= 57) {
                            sr = sr + chars[i];
                            i++;
                        }
                        //不是则减一还原
                        else {
                            i--;
                            break;
                        }
                    }
                }
                list.add(sr);

            }
        }
        return list;
    }

    //判断符号的优先级
    public static int getoper(String s)

    {
        if (s.equals("*") || s.equals("/"))
            return 2;
        else if(s.equals("+") || s.equals("-"))
            return 1;
        else if(s.equals("("))
            return 0;
        else {
            System.out.println("包含错误的操作符");
        };
        return 0;
    }

    //将带空格的字符串转换成list容器
    public static ArrayList<String> tolist(String poland) {
        String[] array = poland.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return (ArrayList<String>) list;
    }

    //计算
    public static int caculator(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            //正则表达式匹配非符号数
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int count = 0;
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if (s.equals("+")) {

                    count = num1 + num2;
                    stack.push(num1 + num2 + "");

                } else if (s.equals("-")) {
                    count = num1 - num2;
                    stack.push(num1 - num2 + "");

                } else if (s.equals("*")) {
                    count = num1 * num2;
                    stack.push(num1 * num2 + "");

                } else if (s.equals("/")) {
                    count = num1 / num2;
                    stack.push(num1 / num2 + "");
                } else {
                    System.out.println("你输入的表达式中包含非法符号");
                    throw new RuntimeException();
                }

            }
        }
        return Integer.parseInt(stack.pop());
    }

}
