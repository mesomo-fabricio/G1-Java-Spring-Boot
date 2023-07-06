package br.com.atitus.trabalhoCRUDG2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEntityProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String unidadeMedida;
    private double valorUnitario;

}
