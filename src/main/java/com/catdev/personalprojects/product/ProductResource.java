package com.catdev.personalprojects.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class ProductResource {
    @Autowired
    private ProductsHardcodedService productManagementService;

    @GetMapping("/stores/{storeName}/products")
    public List<Product> getAllProducts(@PathVariable String storeName){
        return productManagementService.findAll();
    }

    @DeleteMapping("/stores/{storeName}/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String storeName, @PathVariable long id) {

        Product product = productManagementService.deleteById(id);

        if (product != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/stores/{storeName}/products/{id}")
    public Product getProduct(@PathVariable String storeName, @PathVariable long id) {
        return productManagementService.findById(id);
    }

    @PutMapping("/stores/{storeName}/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String storeName, @PathVariable long id,
                                               @RequestBody Product product) {

        Product courseUpdated = productManagementService.save(product);

        return new ResponseEntity<Product>(courseUpdated, HttpStatus.OK);
    }
    @PostMapping("/stores/{storeName}/products")
    public ResponseEntity<Void> createProduct(@PathVariable String storeName, @RequestBody Product product) {

        Product createdProduct = productManagementService.save(product);

        // Location
        // Get current resource url
        /// {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdProduct.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
