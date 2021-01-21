/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */
package com.company;

import java.util.ArrayList;

public class FieldsCollection<T> {
    public  ArrayList<T> list = new ArrayList<>();
    /**
     * Adding the object to the list
     * @param el the new object
     */
    public void Add(T el) {
        if (el!=null)
            list.add(el);
    }
}

