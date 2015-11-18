package com.ricky.clothes.config;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by caiqing on 15/11/18.
 */
public class TestResource {
    public static void main(String args []) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] sources = resolver.getResources("classpath*:com/ricky/clothes/mapper/impl/*.xml");

            for(Resource resource : sources) {
                System.out.println(resource.getFilename());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
