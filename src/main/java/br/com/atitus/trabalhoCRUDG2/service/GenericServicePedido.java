package br.com.atitus.trabalhoCRUDG2.service;

import br.com.atitus.trabalhoCRUDG2.model.GenericEntityPedido;
import br.com.atitus.trabalhoCRUDG2.repository.GenericRepositoryPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GenericServicePedido {

    @Autowired
    private GenericRepositoryPedido pedidoRepository;

    public List<GenericEntityPedido> getPedidos() {
        return pedidoRepository.findAll();
    }

    public ResponseEntity<GenericEntityPedido> getPedidoById(Long id) {
        GenericEntityPedido person = verifyIfPedidoExists(id);
        return ResponseEntity.ok().body(person);
    }

    public GenericEntityPedido postPedido(GenericEntityPedido genericEntityProduto) {
        return pedidoRepository.save(genericEntityProduto);
    }

    public void deletePedido(Long id) {
        GenericEntityPedido person = verifyIfPedidoExists(id);
        pedidoRepository.deleteById(person.getId());
    }

    public ResponseEntity<GenericEntityPedido> updatePerson(Long id, GenericEntityPedido genericEntityProduto) {
        return pedidoRepository.findById(id).map(newPedido -> {
            newPedido.setQuantidade(genericEntityProduto.getQuantidade());
            newPedido.setQuantidade(genericEntityProduto.getQuantidade());
            newPedido.setProduto(genericEntityProduto.getProduto());
            GenericEntityPedido updatedPedido = pedidoRepository.save(newPedido);
            return ResponseEntity.ok().body(updatedPedido);
        }).orElse(ResponseEntity.notFound().build());
    }

    private GenericEntityPedido verifyIfPedidoExists(Long id) throws EntityNotFoundException {
        return pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }
}
