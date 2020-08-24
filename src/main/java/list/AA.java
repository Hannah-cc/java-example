package list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AA {

    static final int NUM = Integer.MAX_VALUE;

    @Test
    public void testA() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            Collections.singletonList(Objects.requireNonNull(i));
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void testB() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            Arrays.asList(i);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void testC() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            List.of(i);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void testD() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            Stream.of(i).collect(Collectors.toList());
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void testE(String... args) {
        System.out.println(args.hashCode());
    }

}
