package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {

    @Autowired
    private ConsumerRepository consumerRepository;

    public static void main(String... args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Consumer consumer1 = new Consumer();
        consumer1.setName("John N Williams");
        consumer1.setAddress("3478 Broadcast Drive");
        consumer1.setEmail("gustave.corw@gmail.com");

        Consumer consumer2 = new Consumer();
        consumer2.setName("Kenneth S Cook");
        consumer2.setAddress("2139 Davis Street");
        consumer2.setEmail("rusty1970@yahoo.com");

        Consumer consumer3 = new Consumer();
        consumer3.setName("May R Goins");
        consumer3.setAddress("4393 Woodland Avenue");
        consumer3.setEmail("bella_schust@gmail.com");

        Consumer consumer4 = new Consumer();
        consumer4.setName("Christine D Verdugo");
        consumer4.setAddress("2999 Elliott Street");
        consumer4.setEmail("dedric2001@yahoo.com");

        consumerRepository.save(consumer1);
        consumerRepository.save(consumer2);
        consumerRepository.save(consumer3);
        consumerRepository.save(consumer4);
    }

}
