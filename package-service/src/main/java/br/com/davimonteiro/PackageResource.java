package br.com.davimonteiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "packages")
public class PackageResource {

    @Autowired
    private PackageService packageService;

    @PostMapping
    public ResponseEntity sendPackage(@RequestBody RetentionStrategy retentionStrategy) {
        packageService.sendPackages(retentionStrategy);
        return ok().build();
    }

}
