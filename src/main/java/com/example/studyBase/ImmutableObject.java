package com.example.studyBase;

public class ImmutableObject {
    private final int value;
     
    public ImmutableObject(int value) {
        this.value = value;
    }
     
    public int getValue() {
        return this.value;
    }
}