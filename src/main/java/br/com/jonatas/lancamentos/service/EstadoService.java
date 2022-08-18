package br.com.jonatas.lancamentos.service;


import br.com.jonatas.lancamentos.model.Estado;
import br.com.jonatas.lancamentos.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EstadoService {

    public Estado salvar(Estado estado) {

        return estadoRepository.save(estado);
    }

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado buscarEstadoPorId(Long id){
        Optional<Estado> estadoSalvo = estadoRepository.findById(id);

        if (!estadoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }
        return estadoSalvo.get();
    }
}
