package br.com.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LinguagemController {
    
    @Autowired
    private LinguagemRepository repositorio;

    // CONSULTA
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repositorio.findByOrderByRanking();
    }

    // CONSULTA POR ID
    @GetMapping("/linguagens/{id}")
    public Linguagem obterLinguagensPorId(@PathVariable String id) {
        return repositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // CADASTRO
    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return new ResponseEntity<>(linguagemSalva, HttpStatus.CREATED);
    }

    // EXCLUSÃO
    @DeleteMapping("/linguagens/{id}")
    public ResponseEntity<?> deletarLinguagem(@PathVariable String id) {
        repositorio.deleteById(id);
        return new ResponseEntity<>("Linguagem deletado com sucesso", HttpStatus.OK);
    }

    // ATUALIZAÇÃO
    @PutMapping("/linguagens")
    public ResponseEntity<?> atualizarLinguagem(@RequestBody Linguagem linguagem){
        if (linguagem.getId() == null){
            return new ResponseEntity<>("Id não foi informado!", HttpStatus.NOT_FOUND);
        }
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return new ResponseEntity<>(linguagemSalva, HttpStatus.OK);
    }
}