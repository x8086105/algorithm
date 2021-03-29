package com.example.springtest;

import com.example.AlgorithmApplication;
import com.example.springTest.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAuto {

    @Autowired
    private TestConfig testConfig;

    @Test
    public void test1(){
        System.out.println(testConfig);
    }
}
