package com.estudos.livraria.DTO;

import com.estudos.livraria.enums.Categoria;
import com.estudos.livraria.enums.StatusLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDto(

        @NotBlank String titulo,

        @NotBlank String autor,

        @NotNull Integer anoDePublicacao,

        @NotNull Categoria categoria,

        @NotNull StatusLivro status
) {}
