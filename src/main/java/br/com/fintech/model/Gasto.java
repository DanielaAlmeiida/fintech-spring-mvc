package br.com.fintech.model;

import br.com.fintech.model.dto.GastoRegisterData;
import br.com.fintech.model.dto.GastoUpdateData;
import jakarta.persistence.*;

@Entity
@Table(name = "gasto" )
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long valor;
    private String descricao;


    //Constructs
    public Gasto() {}

    public Gasto(Long id, Long valor, String descricao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Gasto(GastoRegisterData data) {
        this.valor = data.valor();
        this.descricao = data.descricao();
    }



    //GetsSets
    public Long getId() {
        return id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    //Update
    public void updateGasto(GastoUpdateData data) {
        this.id = data.id();
        this.valor = data.valor();
        this.descricao = data.descricao();
    }

}
