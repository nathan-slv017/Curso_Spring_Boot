package io.github.nathan_slv017.produtosapi.controller;


import io.github.nathan_slv017.produtosapi.model.Produto;
import io.github.nathan_slv017.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController  //
@RequestMapping("/produtos") // @RequestMapping para informar qual URL essa classe tem domínio.
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping // @PostMapping serve para enviar dados, salvar dados
    public Produto salvar(@RequestBody Produto produto) { // @RequestBody é usado para informar a aplicação que o corpo que vier do body do "navegador/externo" será aplicado no parametro da classe
        System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable("id") String id) {
//        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;

        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }
}
