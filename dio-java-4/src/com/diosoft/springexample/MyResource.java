package com.diosoft.springexample;

public class MyResource implements Resource{
    public MyResource(String property) {
        System.out.println("MyResource initiated wit property " +property);
    }
}
