package fr.dojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void getHelloMessage() {
        HelloWorld helloWorld = new HelloWorld();
        String helloMessage = helloWorld.getHelloMessage();
        assertEquals("Hello world !", helloMessage);
    }

}

