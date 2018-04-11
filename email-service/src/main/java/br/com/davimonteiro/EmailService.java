package br.com.davimonteiro;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log
@Service
public class EmailService {

    public static final String CONSUMER_SERVICE = "http://consumer-service/consumers/";

    @Autowired
    private RestTemplate restTemplate;


    public void sendEmail(RetentionStrategy retentionStrategy) {
        Consumer consumer = findConsumerById(retentionStrategy.getConsumerId());

        switch (retentionStrategy.getEmailType()) {
            case "welcome_email":
                sendWelcomeEmails(consumer);
                break;

            case "conservative_promotional_email":
                sendConservativeEmails(consumer);
                break;

            case "moderately_conservative_promotional_email":
                sendModeratelyConservativeEmails(consumer);
                break;

            case "balanced_promotional_email":
                sendBalancedEmails(consumer);
                break;

            case "aggressive_promotional_email":
                sendAggressiveEmails(consumer);
                break;

            case "very_aggressive_promotional_email":
                sendVeryAggressiveEmails(consumer);
                break;
        }
    }

    private void sendWelcomeEmails(Consumer consumer) {
        System.out.println("Sending welcome emails for " + consumer.getEmail());
    }

    private void sendConservativeEmails(Consumer consumer) {
        System.out.println("Sending conservative promotional emails for " + consumer.getEmail());
    }

    private void sendModeratelyConservativeEmails(Consumer consumer) {
        System.out.println("Sending moderately conservative promotional emails for " + consumer.getEmail());
    }

    private void sendBalancedEmails(Consumer consumer) {
        System.out.println("Sending balanced promotional emails for " + consumer.getEmail());
    }

    private void sendAggressiveEmails(Consumer consumer) {
        System.out.println("Sending aggressive promotional emails for " + consumer.getEmail());
    }

    private void sendVeryAggressiveEmails(Consumer consumer) {
        System.out.println("Sending very aggressive promotional emails for " + consumer.getEmail());
    }

    private Consumer findConsumerById(Long id) {
        ResponseEntity<Consumer> responseEntity = restTemplate.getForEntity(CONSUMER_SERVICE + id, Consumer.class);
        Consumer consumer = responseEntity.getBody();
        return consumer;
    }

}
