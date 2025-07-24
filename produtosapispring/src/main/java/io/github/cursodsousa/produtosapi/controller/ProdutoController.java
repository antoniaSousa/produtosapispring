package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.*;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar (@RequestBody Produto produto){
        System.out.println("Produto recebido " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }
    @GetMapping("/{id}")
    public Produto obterProduto (@PathVariable ("id")String id){
//        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);

    }
    @PutMapping("{id}")
    public void atualizarNome(@PathVariable("id") String id,
                              @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);

    }
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
      return produtoRepository.findByNome(nome);
    }
}
