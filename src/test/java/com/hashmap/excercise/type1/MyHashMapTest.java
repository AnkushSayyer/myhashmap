package com.hashmap.excercise.type1;

import com.hashmap.excercise.type1.MyHashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
    MyHashMap<Integer, String> myHashMap;
    @Before
    public void init(){
        myHashMap = new MyHashMap<Integer, String>();
        myHashMap.put(1, "Ankush");
        myHashMap.put(2, "Veneet");
        myHashMap.put(3, "Christopher");
        myHashMap.put(4, "David");
        myHashMap.put(5, "Quentin");
        myHashMap.put(1, "Abc");

        System.out.println(myHashMap.size());
    }

    @Test
    public void test1(){
        Assert.assertEquals("Christopher", myHashMap.get(3));
    }

    @Test
    public void test2(){
        Assert.assertEquals("Abc", myHashMap.get(1));
    }

}