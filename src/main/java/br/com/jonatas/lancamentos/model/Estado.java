package br.com.jonatas.lancamentos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")

    private List<Cidade> cidades= new ArrayList<>();


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return codigo.equals(estado.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


}
