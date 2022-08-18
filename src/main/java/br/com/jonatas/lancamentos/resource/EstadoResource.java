package br.com.jonatas.lancamentos.resource;


import br.com.jonatas.lancamentos.model.Estado;
import br.com.jonatas.lancamentos.repository.EstadoRepository;
import br.com.jonatas.lancamentos.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")

public class EstadoResource {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/todas")
    public List<Estado> listarTodasEstados(){
        return estadoRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarEstadoPeloCodigo(@PathVariable Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.isPresent() ? ResponseEntity.ok(estado.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Estado> criar(@RequestBody Estado estado, HttpServletResponse response) {
        Estado estadoSalva = estadoService.salvar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalva);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        estadoRepository.deleteById(id);
    }
}

