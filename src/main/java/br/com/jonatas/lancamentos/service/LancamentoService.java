package br.com.jonatas.lancamentos.service;


import br.com.jonatas.lancamentos.model.Estado;
import br.com.jonatas.lancamentos.model.Lancamento;
import br.com.jonatas.lancamentos.repository.EstadoRepository;
import br.com.jonatas.lancamentos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){

        return lancamentoRepository.save(lancamento);

    }

    public Lancamento buscarLancamentoPorId(Long id){
        Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(id);

        if (!lancamentoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }
        return lancamentoSalvo.get();
    }
}
