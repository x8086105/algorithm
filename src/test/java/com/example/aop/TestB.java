package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class TestB {
    private TestA testA;
    public TestB(TestA testA){
        this.testA = testA;
    }
}
