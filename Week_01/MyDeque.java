import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {
    public static void main(String[] args) {//改写Deque
        Deque<String> deque = new LinkedList<String>();
        deque.offerFirst("a");
        deque.offerFirst("b");
        deque.offerFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
