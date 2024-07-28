package br.com.api.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.api.model.Pessoa;
import br.com.api.api.repository.Repositor;



@RestController
public class Controller {

    @Autowired
    private Repositor acao;

    
//metodos de rotas
    @PostMapping("/api")
    public Pessoa Cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable Long codigo){
        return acao.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Pessoa Editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public void  deletar(@PathVariable Long codigo){
         Pessoa obj = selecionarPeloCodigo(codigo);
         acao.delete(obj);
        
    }


    @GetMapping("/api/contador")
    public Long contador(){
        return acao.count();
    }

    
    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNomeAsc();
    }

    @GetMapping("/api/ordenarNome2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("Diogo");
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("D");
      
    }

    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartingWith("a");
    }

    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndingWith("A");
    }

    @GetMapping("")
    public String mensagem(){
        return "Hello World";
    }

    @GetMapping("boasVindas")
    public String boasVindas(){
        return "Seja bem vindo " ;
    }

    @GetMapping("boasVindas/{nome}") 
    public String boasVindas(@PathVariable String nome){ // receber um parametro via navegador
        return "Seja bem vindo " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}
