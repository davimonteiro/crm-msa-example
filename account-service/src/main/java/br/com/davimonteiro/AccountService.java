package br.com.davimonteiro;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void sendCards(RetentionStrategy retentionStrategy) {
        System.out.println("Sending cards based on " + retentionStrategy);
    }
}
