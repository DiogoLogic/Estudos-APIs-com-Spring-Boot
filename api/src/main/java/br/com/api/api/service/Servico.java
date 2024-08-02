package br.com.api.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.api.model.Mensagem;
import br.com.api.api.model.Pessoa;
import br.com.api.api.repository.Repositor;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositor acao;


    //validação de cadastro de pessoas
    public ResponseEntity<?> cadastrar(Pessoa obj){
        
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade()<0){
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
           
            return new ResponseEntity<>( acao.save(obj), HttpStatus.CREATED);
        }
    }
    //metodo para selecionar pessoas
    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);

    }

    //metodo para selecionar por codigo
    public ResponseEntity<?> selecionarPeloCodigo(Long codigo){
        if(acao.countByCodigo(codigo)==0){
            mensagem.setMensagem("Não foi encontrada nem uma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }
        
    }

   
}
