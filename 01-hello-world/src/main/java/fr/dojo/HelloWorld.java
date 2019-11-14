package fr.dojo;

public class HelloWorld {

    String getHelloMessage() {
        return "Hello world !";
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        String helloMessage = helloWorld.getHelloMessage();
        System.out.println(helloMessage);
    }

}

