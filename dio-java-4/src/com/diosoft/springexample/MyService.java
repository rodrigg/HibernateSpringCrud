package com.diosoft.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MyService implements Service {

    private final Resource resource;
    private  Resource resource2;

    @Autowired
    @Qualifier(value = "resource3")
    private  Resource resource3;


    public MyService(Resource resource) {
        this.resource = resource;
        System.out.println("MyService initiated");
    }

    public void setResource2(Resource resource2) {
        this.resource2 = resource2;
        System.out.println("MyService2 has been setted");
    }
}
