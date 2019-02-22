package com.hashmap.excercise.type1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mapping<K, V> {
    private K key;
    private V value;
    private Mapping<K, V> next;

    public void setNext(Mapping<K, V> next) {
        this.next = next;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
