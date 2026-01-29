package com.estudos.livraria.entity;

import com.estudos.livraria.enums.Categoria;
import com.estudos.livraria.enums.StatusLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private Integer anoDePublicacao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    public Livro(String titulo, String autor, Integer anoDePublicacao, Categoria categoria, StatusLivro status) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.categoria = categoria;
        this.status = status;
    }
}
