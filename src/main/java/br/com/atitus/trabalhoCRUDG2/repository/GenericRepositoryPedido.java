package br.com.atitus.trabalhoCRUDG2.repository;

import br.com.atitus.trabalhoCRUDG2.model.GenericEntityPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepositoryPedido extends JpaRepository<GenericEntityPedido, Long> {
}
