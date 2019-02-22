package com.hashmap.excercise.type2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mapping<K, V> {
    private K key;
    private V value;

    public void setValue(V value) {
        this.value = value;
    }
}
