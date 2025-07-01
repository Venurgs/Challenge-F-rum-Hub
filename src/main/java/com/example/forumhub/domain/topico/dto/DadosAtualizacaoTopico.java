package com.example.forumhub.domain.topico.dto;

// Para atualização, os campos são opcionais, então não usamos @NotBlank.
// O @Valid no controller garantirá que o JSON seja válido, mas os campos podem ser nulos.
public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        String curso) {
}