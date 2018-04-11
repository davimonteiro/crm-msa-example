package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "profiles")
public class ConsumerProfileResource {

    @Autowired
    private ConsumerProfileRepository consumerProfileRepository;

    @Autowired
    private RetentionStrategyService retentionStrategyService;

    @PostMapping(value = "/analyze")
    public ResponseEntity analyzeConsumerProfile(@RequestBody Consumer consumer) {
        RetentionStrategy retentionStrategy = retentionStrategyService.defineStrategy(consumer);
        return ok(retentionStrategy);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ConsumerProfile profile) {
        ConsumerProfile savedProfile = consumerProfileRepository.save(profile);
        return ok(savedProfile);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List profiles = consumerProfileRepository.findAll();
        return ok(profiles);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) throws ConsumerProfileNotFoundException {
        return consumerProfileRepository.findById(id).map(ResponseEntity::ok)
                .orElseThrow(ConsumerProfileNotFoundException::new);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ConsumerProfile consumerProfile) throws Exception {
        return consumerProfileRepository.findById(id).map(currentConsumerProfile -> {
            copyProperties(consumerProfile, currentConsumerProfile);
            currentConsumerProfile = consumerProfileRepository.save(currentConsumerProfile);
            return ok(currentConsumerProfile);
        }).orElseThrow(ConsumerProfileNotFoundException::new);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        consumerProfileRepository.deleteById(id);
        return noContent().build();
    }

}
