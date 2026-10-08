package state_observer;

public class ChamadoAberto extends ChamadoEstado {

    private ChamadoAberto() {
    }

    private static ChamadoAberto instance = new ChamadoAberto();

    public static ChamadoAberto getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aberto";
    }

    @Override
    public boolean atender(Chamado chamado) {
        chamado.setEstado(ChamadoEmAtendimento.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Chamado chamado) {
        chamado.setEstado(ChamadoCancelado.getInstance());
        return true;
    }
}
