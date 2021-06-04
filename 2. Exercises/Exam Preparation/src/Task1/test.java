package Task1;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class test {
    public static void main(String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.offer(50);
        s.offer(40);
        s.offer(30);
        s.offer(30);
        s.offer(15);

        int e = s.pollLast();
        s.offer(e + 3);



        System.out.println();
    }
}
