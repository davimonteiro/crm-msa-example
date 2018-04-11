package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.davimonteiro.ConsumerProfile.Profile.NEW_INVESTOR;

@Service
public class RetentionStrategyService {

    @Autowired
    private ConsumerProfileRepository consumerProfileRepository;

    @Transactional
    public RetentionStrategy defineStrategy(final Consumer consumer) {
        return consumerProfileRepository.findByConsumerIdEquals(consumer.getId())
                .map(consumerProfile -> {
                    RetentionStrategy retentionStrategy = consumerProfile.getProfile().getRetentionStrategy();
                    retentionStrategy.setConsumerId(consumer.getId());
                    return retentionStrategy;
                })
                .orElseGet(() -> {
                    ConsumerProfile consumerProfile = new ConsumerProfile();
                    consumerProfile.setConsumerId(consumer.getId());
                    consumerProfile.setProfile(NEW_INVESTOR);
                    consumerProfile = consumerProfileRepository.save(consumerProfile);
                    RetentionStrategy retentionStrategy = consumerProfile.getProfile().getRetentionStrategy();
                    retentionStrategy.setConsumerId(consumer.getId());
                    return retentionStrategy;
                });
    }

}
