package com.hashmap.excercise.type1;

import com.hashmap.excercise.type1.Mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashMap<K,V> {
    private int capacity = 200;
    private Set<K> keySet;
    private Set<Mapping<K,V>> entrySet;
    private List<V> values;
    private int size;
    private Mapping<K,V>[] myHashMap;

    public MyHashMap(){
        myHashMap = new Mapping[capacity];
        keySet = new HashSet<K>();
        entrySet = new HashSet<Mapping<K, V>>();
        size = 0;
    }

    public void put(K key, V value){
        int keyHashCode = gethashCode(key);
        int index = keyHashCode%200;
        addToMyHashMap(index, new Mapping<K,V>(key, value, null));
    }

    private void addToMyHashMap(int index, Mapping<K,V> mapping) {
        if (myHashMap[index]==null) {
            myHashMap[index] = mapping;
            size++;
        }
        else {
            addToList(myHashMap[index], mapping);
        }

        addKeyToKeySet(mapping.getKey());
    }

    private void addToList(Mapping<K,V> current, Mapping<K,V> mapping) {
        if(equalKeys(current, mapping)){
            current.setValue(mapping.getValue());
            return;
        }

        while (current.getNext()!=null){
            if(equalKeys(current, mapping)){
                current.setValue(mapping.getValue());
                return;
            }
            current = current.getNext();
        }
        current.setNext(mapping);
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
        else if (myHashMap[index].getNext()==null)
            return (V) myHashMap[index].getValue();
        else
            return findValue(key, myHashMap[index]);
    }

    private V findValue(K key, Mapping<K,V> current) {
        while (current.getNext()!=null){
            if(current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
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
