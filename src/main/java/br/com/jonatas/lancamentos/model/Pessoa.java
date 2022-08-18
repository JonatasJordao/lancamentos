package br.com.jonatas.lancamentos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pessoa")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;



    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name="codigo_cidade")

    private Cidade cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Lancamento> lancamentos_Pessoa = new ArrayList<>();


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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }



    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Lancamento> getLancamentos_Pessoa() {
        return lancamentos_Pessoa;
    }

    public void setLancamentos_Pessoa(List<Lancamento> lancamentos_Pessoa) {
        this.lancamentos_Pessoa = lancamentos_Pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return codigo.equals(pessoa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
