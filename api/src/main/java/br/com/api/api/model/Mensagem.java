package br.com.api.api.model;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {

    private String Mensagem;

    public Mensagem(String mensagem) {
        this.Mensagem = mensagem;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Mensagem [Mensagem=" + Mensagem + "]";
    }

}
