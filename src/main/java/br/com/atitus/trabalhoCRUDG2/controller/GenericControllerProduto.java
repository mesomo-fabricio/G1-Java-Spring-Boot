package br.com.atitus.trabalhoCRUDG2.controller;


import br.com.atitus.trabalhoCRUDG2.model.GenericEntityProduto;
import br.com.atitus.trabalhoCRUDG2.service.GenericServiceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class GenericControllerProduto {

    @Autowired
    private GenericServiceProduto genericServiceProduto;

    @GetMapping("/get")
    public List<GenericEntityProduto> getProducts() {
        return genericServiceProduto.getProducts();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GenericEntityProduto> getProductById(@PathVariable Long id) {
        return genericServiceProduto.getProductById(id);
    }

    @PostMapping("/post")
    public GenericEntityProduto postProduct(@RequestBody GenericEntityProduto genericEntityProduto) {
        return genericServiceProduto.postProduct(genericEntityProduto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProducts(@PathVariable Long id) {
        genericServiceProduto.deleteProducts(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<GenericEntityProduto> updatePerson(@PathVariable Long id, @RequestBody GenericEntityProduto genericEntityProduto) {
        return genericServiceProduto.updatePerson(id, genericEntityProduto);
    }

}
