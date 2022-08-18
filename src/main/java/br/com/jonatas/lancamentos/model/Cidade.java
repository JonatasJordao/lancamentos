package br.com.jonatas.lancamentos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;


    @ManyToOne
    @JoinColumn(name="codigo_estado")

    private Estado estado;


    @JsonIgnore
    @OneToMany(mappedBy = "cidade")
    private List<Pessoa> pessoas = new ArrayList<>();



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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return codigo.equals(cidade.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
