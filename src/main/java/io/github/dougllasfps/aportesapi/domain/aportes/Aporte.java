package io.github.dougllasfps.aportesapi.domain.aportes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data@NoArgsConstructor
public class Aporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer ano;
    @Column
    private Integer mes;
    @Column(name = "saldo_anterior")
    private BigDecimal saldoAnterior;
    @Column
    private BigDecimal valor;
    @Column
    private Long usuarioid;

}
