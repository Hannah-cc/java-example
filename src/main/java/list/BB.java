package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList和LinkedList;
 * 头部add和尾部add的性能对比
 */
public class BB {

    private static final int LIST_SIZE = 10000000;

    private static final int TIMES = 5000;

    private static final List<Integer> ARRAY_LIST;

    private static final List<Integer> LINKED_LIST;

    static {
        ARRAY_LIST = new ArrayList<>(LIST_SIZE + TIMES);
        LINKED_LIST = new LinkedList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            ARRAY_LIST.add(i);
            LINKED_LIST.add(i);
        }
        System.out.println("arrayList.size: " + ARRAY_LIST.size());
        System.out.println("linkedList.size: " + LINKED_LIST.size());
    }

    public static void main(String[] args) {
        System.gc();

        long tm0 = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            ARRAY_LIST.add(0, i);
        }
        long tm1 = System.currentTimeMillis();

        System.gc();

        long tm2 = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            ARRAY_LIST.add(i);
        }
        long tm3 = System.currentTimeMillis();

        System.gc();

        long tm4 = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            LINKED_LIST.add(0, i);
        }
        long tm5 = System.currentTimeMillis();

        System.gc();

        long tm6 = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            LINKED_LIST.add(i);
        }
        long tm7 = System.currentTimeMillis();

        System.out.println("arrayList add first: " + (tm1 - tm0));
        System.out.println("arrayList add last: " + (tm3 - tm2));
        System.out.println("linkedList add first: " + (tm5 - tm4));
        System.out.println("linkedList add last: " + (tm7 - tm6));
    }

}
