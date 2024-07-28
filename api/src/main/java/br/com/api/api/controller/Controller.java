package br.com.api.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.api.api.model.Pessoa;
import br.com.api.api.repository.Repositor;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Repositor acao;

    // Método para cadastrar uma nova pessoa
    @PostMapping
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    // Método para obter todas as pessoas
    @GetMapping
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    // Método para obter uma pessoa pelo código
    @GetMapping("/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable Long codigo){
        return acao.findByCodigo(codigo);
    }

    // Método para editar uma pessoa existente
    @PutMapping
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    // Método para deletar uma pessoa pelo código
    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable Long codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    // Método para contar o número de pessoas
    @GetMapping("/contador")
    public Long contador(){
        return acao.count();
    }

    // Método para obter pessoas ordenadas pelo nome em ordem ascendente
    @GetMapping("/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNomeAsc();
    }

    // Método para obter pessoas com um nome específico ordenadas pela idade em ordem descendente
    @GetMapping("/ordenarNome2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("Diogo");
    }

    // Método para obter pessoas cujo nome contém um caractere específico
    @GetMapping("/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("D");
    }

    // Método para obter pessoas cujo nome inicia com um caractere específico
    @GetMapping("/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartingWith("a");
    }

    // Método para obter pessoas cujo nome termina com um caractere específico
    @GetMapping("/terminaCom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndingWith("A");
    }

    // Método para somar as idades de todas as pessoas
    @GetMapping("/somaIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }

    // Método para retornar uma mensagem "Hello World"
    @GetMapping("/")
    public String mensagem(){
        return "Hello World";
    }

    // Método para retornar uma mensagem de boas-vindas
    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja bem vindo";
    }

    // Método para retornar uma mensagem de boas-vindas personalizada
    @GetMapping("/boasVindas/{nome}") 
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo " + nome;
    }

    // Método para retornar a pessoa recebida no corpo da requisição
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}
