package br.com.atitus.trabalhoCRUDG2.repository;

import br.com.atitus.trabalhoCRUDG2.model.GenericEntityProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepositoryProduto extends JpaRepository<GenericEntityProduto, Long> {
}
