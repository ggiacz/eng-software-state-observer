package state_observer;

public abstract class ChamadoEstado {

    public abstract String getEstado();

    public boolean atender(Chamado chamado) {
        return false;
    }

    public boolean resolver(Chamado chamado) {
        return false;
    }

    public boolean fechar(Chamado chamado) {
        return false;
    }

    public boolean cancelar(Chamado chamado) {
        return false;
    }
}
