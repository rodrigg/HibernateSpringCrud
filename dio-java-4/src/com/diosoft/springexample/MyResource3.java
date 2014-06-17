package com.diosoft.springexample;

import org.springframework.stereotype.*;

@org.springframework.stereotype.Service("resource3")

public class MyResource3 implements Resource {

    public MyResource3() {

        System.out.println("Resource 3 initiated");
    }
}
