import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex {
    void voidTestHalf() {
        int[] intArray = {1, 8, 7, 2, 9, 18, 12, 0};
        LinkedList myNumbers = new LinkedList<Integer>() {{
            add(1);
            add(8);
            add(7);
            add(2);
            add(9);
            add(18);
            add(12);
            add(0);
        }};
        reverseHalf(myNumbers);
    }

    void reverseHalf(Queue<Integer> q) {

        System.out.println(q.toString());

        Stack<Integer> s = new Stack<>();

        int size = q.size();

        for (int i = 0; i < size; i++) {
            if (i % 2 == 1)
                s.push(q.remove());
            else
                q.add(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(q.remove());
            q.add(s.pop());
        }

        if (size % 2 == 1)
            q.add(q.remove());

        System.out.println(q.toString());
    }
}
