package com.example.aop;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestA {
    private TestB testB;
    public TestA(TestB testB){


    }
}
