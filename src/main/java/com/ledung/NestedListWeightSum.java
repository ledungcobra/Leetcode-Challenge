package com.ledung;

import java.util.ArrayList;
import java.util.List;

class NestedInteger {
    private List<NestedInteger> list;

    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    private Integer value;

    public NestedInteger(int value) {
        this.value = value;
    }

    public Integer getInteger() {
        return value;
    }

    public boolean isInteger() {
        return this.value != null;
    }

    public NestedInteger add(NestedInteger ni) {
        this.list.add(ni);
        return this;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}


public class NestedListWeightSum {
    public static int depthSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger()) {
                sum += integer.getInteger() * level;
            } else {
                sum += depthSum(integer.getList(), level + 1);
            }
        }
        return sum;
    }

    public static int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        int level = 1;
        while (nestedList.size() != 0) {
            List<NestedInteger> tmp = new ArrayList<>();
            for (NestedInteger e : nestedList) {
                if (e.isInteger()) {
                    sum += level * e.getInteger();
                } else {
                    tmp.addAll(e.getList());
                }
            }
            level++;
            nestedList = tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<NestedInteger> list = List.of(
                new NestedInteger().add(new NestedInteger(1)).add(new NestedInteger(1)),
                new NestedInteger(2),
                new NestedInteger().add(new NestedInteger(1)).add(new NestedInteger(1))
        );
//        System.out.println(depthSum(list, 1));
        System.out.println(depthSum(list));
    }

}
