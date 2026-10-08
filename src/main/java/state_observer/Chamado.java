package state_observer;

import java.util.Observable;

public class Chamado extends Observable {

    private String descricao;
    private ChamadoEstado estado;
    private Solicitante solicitante;

    public Chamado(Solicitante solicitante) {
        if(solicitante == null) {
            System.out.println("Não existe solicitante associado a esse chamado");
        }
        this.solicitante = solicitante;
        this.estado = ChamadoAberto.getInstance();
    }

    public void setEstado(ChamadoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public ChamadoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public boolean atender() {
        return estado.atender(this);
    }

    public boolean resolver() {
        return estado.resolver(this);
    }

    public boolean fechar() {
        return estado.fechar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "descricao='" + descricao + '\'' +
                ", estado=" + estado.getEstado() +
                '}';
    }
}
