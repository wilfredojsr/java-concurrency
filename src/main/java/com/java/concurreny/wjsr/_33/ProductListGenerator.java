package com.java.concurreny.wjsr._33;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductListGenerator {

    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();

        IntStream.range(0, size).forEach(i -> {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        });

        return ret;

    }
}
