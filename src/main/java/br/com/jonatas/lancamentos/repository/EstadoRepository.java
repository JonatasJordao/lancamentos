package br.com.jonatas.lancamentos.repository;


import br.com.jonatas.lancamentos.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EstadoRepository extends JpaRepository<Estado, Long> {


}

