package com.ricky.clothes;

import org.junit.Test;

import java.util.*;

/**
 * Created by caiqing on 16/3/18.
 */
public class UtilTests {

    @Test
    public void testList() {
        List<String> list = new ArrayList<String>();

        Map<String, String> map = new HashMap<String, String>();

//        Arrays.asList("test", "ag", "ricky").forEach(e -> System.out.println(e));

        Arrays.asList("test", "ag", "ricky").forEach(e -> {
            System.out.println(e);
            System.out.println(e + "/");
        });

        Optional<String> testOptional = Optional.of("test");



    }
}
