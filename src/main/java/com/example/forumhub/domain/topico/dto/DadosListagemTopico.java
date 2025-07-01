package com.example.forumhub.domain.topico.dto;

import com.example.forumhub.domain.topico.Topico;
import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean status,
        String autor,
        String curso) {

    // Construtor adicional que recebe uma entidade Topico e a converte neste DTO
    public DadosListagemTopico(Topico topico) {
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