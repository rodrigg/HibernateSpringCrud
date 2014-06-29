package com.diosoft.springexample;

public class MyFactoryImpl implements MyFactory {

    public Resource createResource(){
        return new MyResource("some");
    }
}
