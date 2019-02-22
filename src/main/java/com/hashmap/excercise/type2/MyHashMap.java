package com.hashmap.excercise.type2;

import com.hashmap.excercise.type2.Mapping;

import java.util.*;

public class MyHashMap<K,V> {
    private int capacity = 200;
    private Set<K> keySet;
    private Set<Mapping<K,V>> entrySet;
    private List<V> values;
    private int size;
    private ArrayList<Mapping>[] myHashMap;

    public MyHashMap(){
        myHashMap = new ArrayList[capacity];
        keySet = new HashSet<K>();
        entrySet = new HashSet<Mapping<K, V>>();
        size = 0;
    }

    public void put(K key, V value){
        int keyHashCode = gethashCode(key);
        int index = keyHashCode%200;
        addToMyHashMap(index, new Mapping<K,V>(key, value));
    }

    private void addToMyHashMap(int index, Mapping<K,V> mapping) {
        if (myHashMap[index] == null) {
            myHashMap[index] = new ArrayList<Mapping>();
            myHashMap[index].add(mapping);
            size++;
        }
        else
            addToList(myHashMap[index], mapping);
        addKeyToKeySet(mapping.getKey());
    }

    private void addToList(ArrayList<Mapping> list, Mapping<K,V> mapping) {
        if(equalKeys(list.get(0), mapping)){
            list.get(0).setValue(mapping.getValue());
            return;
        }

        for (Mapping current : list){
            if(equalKeys(current, mapping)){
                current.setValue(mapping.getValue());
                return;
            }
        }

        list.add(mapping);
        size++;
    }

    private boolean equalKeys(Mapping<K,V> current, Mapping<K,V> mapping) {
        if (current.getKey().equals(mapping.getKey()))
            return true;
        return false;
    }

    public V get(K key){
        int keyHashCode = gethashCode(key);
        int index = keyHashCode%200;

        if (myHashMap[index]==null)
            return null;
        else if (myHashMap[index].size()==1)
            return (V) myHashMap[index].get(0).getValue();
        else
            return findValue(key, myHashMap[index]);
    }

    private V findValue(K key, ArrayList<Mapping> list) {
        for (Mapping current : list){
            if(current.getKey().equals(key)) {
                return (V)current.getValue();
            }
        }
        return null;
    }

    private void addKeyToKeySet(K key) {
        keySet.add(key);
    }

    public boolean isEmpty(){
        if (keySet.size()==0)
            return true;
        else
            return false;
    }

    public boolean containsKey(K key){
        return keySet.contains(key);
    }

    public Set<K> keySet(){
        return keySet;
    }

    public int size(){
        return size;
    }

    public Set<Mapping<K,V>> entrySet(){
        return entrySet;
    }

    public List<V> values(){
        return values;
    }

    private int gethashCode(K key){
        return key.hashCode();
    }

}
