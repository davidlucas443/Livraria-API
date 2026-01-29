package com.estudos.livraria.DTO;

import com.estudos.livraria.enums.Categoria;
import com.estudos.livraria.enums.StatusLivro;

public record LivroResponseDto(

        Long id,
        String titulo,
        String autor,
        Categoria categoria,
        StatusLivro status
) {}
