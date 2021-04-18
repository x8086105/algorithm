package com.example.springtest;

import com.example.AlgorithmApplication;
import com.example.algorithm.dataStructure.Set;
import com.example.springTest.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

public class TestAuto {
    @Test
    public void test() {
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person(1, "Java后端技术栈"));
        hashSet.add(new Person(1, "Java后端技术栈"));
        hashSet.add(new Person(1, "Java后端技术栈"));
        System.out.println(hashSet.size());
        Person a = new Person(1, "Java后端技术栈");
        Person a2 = new Person(1, "Java后端技术栈");
        System.out.println(a == a2);
        System.out.println(a.equals(a2));
        System.out.println(a.hashCode() == a2.hashCode());
    }

    private class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }


//
//        @Override
//        public int hashCode() {
//            return age+ name.hashCode();
//        }
    }

}
