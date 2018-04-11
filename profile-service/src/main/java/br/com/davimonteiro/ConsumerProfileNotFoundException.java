package br.com.davimonteiro;

public class ConsumerProfileNotFoundException extends Exception {

    public ConsumerProfileNotFoundException() {
        super("Consumer profile not found.");
    }

}
