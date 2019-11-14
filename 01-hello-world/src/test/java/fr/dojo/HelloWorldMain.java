package fr.dojo;

public class HelloWorldMain {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        String helloMessage = helloWorld.getHelloMessage();
        System.out.println(helloMessage);
    }

}

