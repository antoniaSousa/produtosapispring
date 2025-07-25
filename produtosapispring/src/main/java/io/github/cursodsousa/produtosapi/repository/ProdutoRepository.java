package io.github.cursodsousa.produtosapi.repository;

import io.github.cursodsousa.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String>{
        String id(String id);

        List<Produto> findByNome(String nome);
    }
