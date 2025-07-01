package com.example.forumhub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

// Um record é ideal para DTOs, pois é imutável e já vem com construtores, getters, equals e hashCode.
public record DadosCadastroTopico(

        @NotBlank(message = "Título é obrigatório") // Validação: não pode ser nulo nem vazio
        String titulo,

        @NotBlank(message = "Mensagem é obrigatória")
        String mensagem,

        @NotBlank(message = "Autor é obrigatório")
        String autor,

        @NotBlank(message = "Curso é obrigatório")
        String curso
) {
}