package br.com.jonatas.lancamentos.service;

import br.com.jonatas.lancamentos.model.Pessoa;
import br.com.jonatas.lancamentos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoaPorId(Long id){
        Optional<Pessoa> pessoaSalva = pessoaRepository.findById(id);

        if (!pessoaSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return pessoaSalva.get();
    }

}
