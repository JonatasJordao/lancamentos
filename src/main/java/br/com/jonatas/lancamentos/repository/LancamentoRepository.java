package br.com.jonatas.lancamentos.repository;


import br.com.jonatas.lancamentos.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
