import java.util.Stack;

/**
 * <p>
 * Title:
 * </p>
 * Description:
 * <p>
 *
 * @author jerry
 * @version Date: 2019/3/11
 */
public class StackTest {
    public static void main(String[] args) {
        System.out.println(checkStrMatch("}"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
     *
     * @param str
     * @return
     */
    public static boolean checkStrMatch(String str) {
        Stack<Character> s = new Stack<>();

        for (char c : str.toCharArray()) {
            if (0 == s.size()) {
                s.push(c);
            } else if (checkMatch(s.peek(), c)) {
                s.pop();
            } else {
                s.push(c);
            }
        }

        return s.size() == 0;
    }

    private static boolean checkMatch(char char1, char char2) {
        return (char1 == '{' && char2 == '}') || (char1 == '[' && char2 == ']') || (char1 == '(' && char2 == ')');
    }

    /**
     * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
     */
    private static Stack<Object> sa = new Stack<>();
    private static Stack<Object> sb = new Stack<>();

    public static void push(Object a){
        sa.push(a);
    }

    public static Object pop(){
        if(sb.size() == 0){
            while (sa.size() != 0){
                Object a = sa.pop();
                sb.push(a);
            }
        }

        if (sb.size() == 0)
            return new Exception("queue is empty");

        return sb.pop();
    }

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列 1，2，3，4，5 是某栈的压入顺序，序列 4，5，3，2，1是该压栈序列对应的一个弹出序列，但4，3，5，1，2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     *
     * @param arrayA
     * @param arrayB
     * @return
     */
//    public static boolean checkStackPopQueue(Object[] arrayA, Object[] arrayB){
//        if (arrayA.length != arrayB.length){
//            return false;
//        }
//
//
//    }
}
