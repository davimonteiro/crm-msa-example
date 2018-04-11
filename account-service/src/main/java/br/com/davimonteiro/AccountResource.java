package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "cards-passwords")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity sendCards(@RequestBody RetentionStrategy retentionStrategy) {
        accountService.sendCards(retentionStrategy);
        return ok().build();
    }


}
