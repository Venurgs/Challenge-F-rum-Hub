package com.example.forumhub.controller;

import com.example.forumhub.domain.topico.Topico;
import com.example.forumhub.domain.topico.TopicoRepository;
import com.example.forumhub.domain.topico.dto.DadosAtualizacaoTopico;
import com.example.forumhub.domain.topico.dto.DadosCadastroTopico;
import com.example.forumhub.domain.topico.dto.DadosDetalhamentoTopico;
import com.example.forumhub.domain.topico.dto.DadosListagemTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados.titulo(), dados.mensagem(), dados.autor(), dados.curso());
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAllByStatusTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topicoOptional = repository.findById(id);
        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topicoOptional.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.desativar();
        return ResponseEntity.noContent().build();
    }
}