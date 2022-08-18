package br.com.jonatas.lancamentos.service;

import br.com.jonatas.lancamentos.model.Categoria;
import br.com.jonatas.lancamentos.model.Cidade;
import br.com.jonatas.lancamentos.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){
        return cidadeRepository.save(cidade);
    }


    public Cidade atualizar(Long id, Cidade cidade){
        Cidade cidadeSalva = buscarCidadePorId(id);

        BeanUtils.copyProperties(cidade, cidadeSalva, "id");
        return cidadeRepository.save(cidadeSalva);
    }

    public Cidade buscarCidadePorId(Long id){
        Optional<Cidade> cidadeSalva = cidadeRepository.findById(id);

        if (!cidadeSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return cidadeSalva.get();
    }
}
