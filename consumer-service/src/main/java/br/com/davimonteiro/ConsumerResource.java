package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "consumers")
public class ConsumerResource {

    @Autowired
    private ConsumerRepository consumerRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody Consumer consumer) {
        Consumer savedConsumer = consumerRepository.save(consumer);
        return ok(savedConsumer);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List consumers = consumerRepository.findAll();
        return ok(consumers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) throws ConsumerNotFoundException {
        return consumerRepository.findById(id).map(ResponseEntity::ok)
                .orElseThrow(ConsumerNotFoundException::new);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Consumer consumer) throws Exception {
        return consumerRepository.findById(id).map(currentConsumer -> {
            copyProperties(consumer, currentConsumer);
            currentConsumer = consumerRepository.save(currentConsumer);
            return ok(currentConsumer);
        }).orElseThrow(ConsumerNotFoundException::new);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        consumerRepository.deleteById(id);
        return noContent().build();
    }

}
