package com.estudos.livraria.service;

import com.estudos.livraria.DTO.LivroRequestDto;
import com.estudos.livraria.entity.Livro;
import com.estudos.livraria.enums.StatusLivro;
import com.estudos.livraria.repositories.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro adicionarLivro(LivroRequestDto dto) {
        Livro livro = new Livro(
                dto.titulo(),
                dto.autor(),
                dto.anoDePublicacao(),
                dto.categoria(),
                dto.status()
        );
        livroRepository.save(livro);
        return livro;
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro atualizarLivrosPorId(Long id){
        return livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }

    public void removerLivroPorId(Long id){
        if(!livroRepository.existsById(id)){
            throw new EntityNotFoundException("Livro não encontrado");
        }
        livroRepository.deleteById(id);
    }

    @Transactional
    public Livro atualizarLivroPorId(Long id, LivroRequestDto dto){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        livro.setTitulo(dto.autor());
        livro.setAutor(dto.autor());
        livro.setAnoDePublicacao(dto.anoDePublicacao());
        livro.setCategoria(dto.categoria());
        livro.setStatus(dto.status());
        return livro;
    }

    public Livro emprestarPorId(Long id){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        if(livro.getStatus() == StatusLivro.EMPRESTADO){
            throw new IllegalStateException("Livro já está emprestado");
        }
        livro.setStatus(StatusLivro.EMPRESTADO);
        return livro;
    }


}
