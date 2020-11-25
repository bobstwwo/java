package main;

import java.util.ArrayList;

public class FieldsCollection<T> {
    public  ArrayList<T> list = new ArrayList<>();

    public void Add(T el) {
        if (list.add(el)) ;
    }
}

