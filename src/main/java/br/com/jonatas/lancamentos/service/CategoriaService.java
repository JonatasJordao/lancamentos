package br.com.jonatas.lancamentos.service;

import br.com.jonatas.lancamentos.model.Categoria;
import br.com.jonatas.lancamentos.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoria){
        Categoria categoriaSalva = buscarCategoriaPorId(id);

        BeanUtils.copyProperties(categoria, categoriaSalva, "id");
        return categoriaRepository.save(categoriaSalva);
    }


    public Categoria buscarCategoriaPorId(Long id){
        Optional<Categoria> categoriaSalva = categoriaRepository.findById(id);

        if (!categoriaSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return categoriaSalva.get();
    }
}
