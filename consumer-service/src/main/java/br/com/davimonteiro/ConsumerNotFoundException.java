package br.com.davimonteiro;

public class ConsumerNotFoundException extends Exception {

    public ConsumerNotFoundException() {
        super("Consumer not found.");
    }

}
