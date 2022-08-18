package br.com.jonatas.lancamentos.resource;

import br.com.jonatas.lancamentos.model.Categoria;
import br.com.jonatas.lancamentos.repository.CategoriaRepository;
import br.com.jonatas.lancamentos.service.CategoriaService;
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
@RequestMapping("/categorias")

public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/todas")
    public List<Categoria> listarTodasCategorias(){
        return categoriaRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable  Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        Categoria categoriaSalva = categoriaService.atualizar(id, categoria);

        return ResponseEntity.ok(categoriaSalva);
    }
}
