package com.example.forumhub.domain.topico.dto;

import com.example.forumhub.domain.topico.Topico;
import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean status,
        String autor,
        String curso) {

    // Construtor que converte a entidade Topico para este DTO
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}