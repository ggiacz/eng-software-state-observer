package state_observer;

public class ChamadoCancelado extends ChamadoEstado {

    private ChamadoCancelado() {
    }

    private static ChamadoCancelado instance = new ChamadoCancelado();

    public static ChamadoCancelado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
