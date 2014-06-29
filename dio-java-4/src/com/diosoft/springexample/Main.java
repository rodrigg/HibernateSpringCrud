package com.diosoft.springexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(
                "com/diosoft/springexample/applicationContext.xml"
        );
    }
}
