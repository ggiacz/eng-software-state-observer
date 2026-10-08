package state_observer;

public class ChamadoFechado extends ChamadoEstado {

    private ChamadoFechado() {
    }

    private static ChamadoFechado instance = new ChamadoFechado();

    public static ChamadoFechado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Fechado";
    }
}
