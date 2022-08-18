package br.com.jonatas.lancamentos.repository;


import br.com.jonatas.lancamentos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
