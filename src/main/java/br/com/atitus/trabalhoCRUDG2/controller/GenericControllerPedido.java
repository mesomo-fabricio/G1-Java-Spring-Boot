package br.com.atitus.trabalhoCRUDG2.controller;

import br.com.atitus.trabalhoCRUDG2.model.GenericEntityPedido;
import br.com.atitus.trabalhoCRUDG2.service.GenericServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class GenericControllerPedido {

    @Autowired
    private GenericServicePedido genericServicePedido;

    @GetMapping("/get")
    public List<GenericEntityPedido> getPedidos() {
        return genericServicePedido.getPedidos();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GenericEntityPedido> getPedidoById(@PathVariable Long id) {
        return genericServicePedido.getPedidoById(id);
    }

    @PostMapping("/post")
    public GenericEntityPedido postPedido(@RequestBody GenericEntityPedido genericEntityProduto) {
        return genericServicePedido.postPedido(genericEntityProduto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePedido(@PathVariable Long id) {
        genericServicePedido.deletePedido(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<GenericEntityPedido> updatePerson(@PathVariable Long id, @RequestBody GenericEntityPedido genericEntityProduto) {
        return genericServicePedido.updatePerson(id, genericEntityProduto);
    }

}
