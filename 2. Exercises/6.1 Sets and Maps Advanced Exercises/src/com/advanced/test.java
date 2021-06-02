package com.advanced;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<>());
        s.get(0).add(17);
        s.get(0).add(12);
        s.get(0).add(2);
        s.add(new ArrayList<>());
        s.get(1).add(5);
        s.get(1).add(14);
        s.get(1).add(3);
        s.add(new ArrayList<>());
        s.get(2).add(2);
        s.get(2).add(11);
        s.get(2).add(12);

        System.out.println();
    }
}
