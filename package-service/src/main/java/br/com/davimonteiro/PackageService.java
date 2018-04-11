package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PackageService {

    public static final String CONSUMER_SERVICE = "http://consumer-service/consumers/";

    @Autowired
    private RestTemplate restTemplate;

    public void sendPackages(RetentionStrategy retentionStrategy) {

        Consumer consumer = findConsumerById(retentionStrategy.getConsumerId());

        switch (retentionStrategy.getPackageType()) {
            case "welcome_package":
                sendWelcomePackages(consumer);
                break;

            case "conservative_promotional_package":
                sendConservativePackages(consumer);
                break;

            case "moderately_conservative_promotional_package":
                sendModeratelyConservativePackages(consumer);
                break;

            case "balanced_promotional_package":
                sendBalancedPackages(consumer);
                break;

            case "aggressive_promotional_package":
                sendAggressivePackages(consumer);
                break;

            case "very_aggressive_promotional_package":
                sendVeryAggressivePackages(consumer);
                break;
        }
    }

    private void sendWelcomePackages(Consumer consumer) {
        System.out.println("Sending welcome packages for " + consumer.toString());
    }

    private void sendConservativePackages(Consumer consumer) {
        System.out.println("Sending conservative promotional packages for " + consumer.toString());
    }

    private void sendModeratelyConservativePackages(Consumer consumer) {
        System.out.println("Sending moderately conservative promotional packages for " + consumer.toString());
    }

    private void sendBalancedPackages(Consumer consumer) {
        System.out.println("Sending balanced conservative promotional packages for " + consumer.toString());
    }

    private void sendAggressivePackages(Consumer consumer) {
        System.out.println("Sending a package for " + consumer.toString());
    }

    private void sendVeryAggressivePackages(Consumer consumer) {
        System.out.println("Sending a package for " + consumer.toString());
    }

    private Consumer findConsumerById(Long id) {
        ResponseEntity<Consumer> responseEntity = restTemplate.getForEntity(CONSUMER_SERVICE + id, Consumer.class);
        Consumer consumer = responseEntity.getBody();
        return consumer;
    }

}
