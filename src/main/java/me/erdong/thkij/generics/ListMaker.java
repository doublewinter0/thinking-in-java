package me.erdong.thkij.generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        X<String> a = new X<>();
        List<String> list = a.create();
        // list.add()


        ListMaker x = new ListMaker<>();
        List xList = x.create();
        xList.add(1);
        xList.add(2);
        xList.add("x");
        System.out.println(xList);
    }
}

class X<T> extends ListMaker<T> {

}