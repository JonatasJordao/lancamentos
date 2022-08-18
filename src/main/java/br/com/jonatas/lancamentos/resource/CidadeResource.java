package br.com.jonatas.lancamentos.resource;

import br.com.jonatas.lancamentos.model.Categoria;
import br.com.jonatas.lancamentos.model.Cidade;
import br.com.jonatas.lancamentos.repository.CidadeRepository;
import br.com.jonatas.lancamentos.service.CategoriaService;
import br.com.jonatas.lancamentos.service.CidadeService;
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
@RequestMapping("/cidades")

public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/todas")
    public List<Cidade> listarTodasCidades(){


        return cidadeRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarCidadePeloCodigo(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cidade.isPresent() ? ResponseEntity.ok(cidade.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Cidade> criar(@RequestBody Cidade cidade, HttpServletResponse response){
        Cidade cidadeSalva = cidadeService.salvar(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        cidadeRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade){
        Cidade cidadeSalva = cidadeService.atualizar(id, cidade);

        return ResponseEntity.ok(cidadeSalva);

    }
}
