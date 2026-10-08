package state_observer;

import java.util.Observable;
import java.util.Observer;

public class Solicitante implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Solicitante(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void acompanhar(Chamado chamado) {
        chamado.addObserver(this);
    }

    @Override
    public void update(Observable chamado, Object arg) {
        this.ultimaNotificacao =
                this.nome + ", chamado atualizado: " + chamado.toString();
    }
}
