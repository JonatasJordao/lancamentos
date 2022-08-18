package br.com.jonatas.lancamentos.resource;



import br.com.jonatas.lancamentos.model.Lancamento;
import br.com.jonatas.lancamentos.repository.LancamentoRepository;
import br.com.jonatas.lancamentos.service.LancamentoService;
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
@RequestMapping("/lancamentos")



public class LancamentoResource {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/todos")
    public List<Lancamento> listarTodosLancamentos(){
        return lancamentoRepository.findAll(Sort.by("dataVencimento").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarLancamentoPeloCodigo(@PathVariable Long id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Lancamento> criar(@RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalva = lancamentoService.salvar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        lancamentoRepository.deleteById(id);
    }
}
