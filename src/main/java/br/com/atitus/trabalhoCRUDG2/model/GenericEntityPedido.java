package br.com.atitus.trabalhoCRUDG2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEntityPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    private double quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private GenericEntityProduto produto;
}
