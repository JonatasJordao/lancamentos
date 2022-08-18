package br.com.jonatas.lancamentos.repository;

import br.com.jonatas.lancamentos.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CidadeRepository  extends JpaRepository<Cidade, Long> {
}
