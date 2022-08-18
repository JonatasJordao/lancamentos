package br.com.jonatas.lancamentos.resource;

import br.com.jonatas.lancamentos.model.Pessoa;
import br.com.jonatas.lancamentos.repository.PessoaRepository;
import br.com.jonatas.lancamentos.service.PessoaService;
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
@RequestMapping("/pessoas")

public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/todas")

    public List<Pessoa> listarTodasPessoas(){
        return pessoaRepository.findAll(Sort.by("nome").ascending());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPeloCodigo(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.isPresent() ? ResponseEntity.ok(pessoa.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}

