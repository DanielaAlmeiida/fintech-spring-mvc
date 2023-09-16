package br.com.fintech.model;

import br.com.fintech.model.dto.GastoRegisterData;
import br.com.fintech.model.dto.GastoUpdateData;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "gasto" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long valor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    //Register
    public Gasto(GastoRegisterData data) {
        this.valor = data.valor();
        this.descricao = data.descricao();
    }

    //Update
    public void updateGasto(GastoUpdateData data) {
        this.id = data.id();
        this.valor = data.valor();
        this.descricao = data.descricao();
    }

}
