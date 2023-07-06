package br.com.atitus.trabalhoCRUDG2.service;

import br.com.atitus.trabalhoCRUDG2.model.GenericEntityProduto;
import br.com.atitus.trabalhoCRUDG2.repository.GenericRepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GenericServiceProduto {

    @Autowired
    private GenericRepositoryProduto repository;

    public List<GenericEntityProduto> getProducts() {
        return repository.findAll();
    }

    public ResponseEntity<GenericEntityProduto> getProductById(Long id) {
        GenericEntityProduto person = verifyIfProductExists(id);
        return ResponseEntity.ok().body(person);
    }

    public GenericEntityProduto postProduct(GenericEntityProduto genericEntityProduto) {
        return repository.save(genericEntityProduto);
    }

    public void deleteProducts(Long id) {
        GenericEntityProduto person = verifyIfProductExists(id);
        repository.deleteById(person.getId());
    }

    public ResponseEntity<GenericEntityProduto> updatePerson(Long id, GenericEntityProduto genericEntityProduto) {
        return repository.findById(id).map(newProduct -> {
            newProduct.setNome(genericEntityProduto.getNome());
            newProduct.setDescricao(genericEntityProduto.getDescricao());
            newProduct.setUnidadeMedida(genericEntityProduto.getUnidadeMedida());
            newProduct.setValorUnitario(genericEntityProduto.getValorUnitario());
            GenericEntityProduto updatedProduct = repository.save(newProduct);
            return ResponseEntity.ok().body(updatedProduct);
        }).orElse(ResponseEntity.notFound().build());
    }

    private GenericEntityProduto verifyIfProductExists(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }
}
