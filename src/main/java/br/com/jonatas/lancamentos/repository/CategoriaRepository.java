package br.com.jonatas.lancamentos.repository;

import br.com.jonatas.lancamentos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    

}
