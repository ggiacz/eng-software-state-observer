package state_observer;

public class ChamadoEmAtendimento extends ChamadoEstado {

    private ChamadoEmAtendimento() {
    }

    private static ChamadoEmAtendimento instance = new ChamadoEmAtendimento();

    public static ChamadoEmAtendimento getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Atendimento";
    }

    @Override
    public boolean resolver(Chamado chamado) {
        chamado.setEstado(ChamadoResolvido.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Chamado chamado) {
        chamado.setEstado(ChamadoCancelado.getInstance());
        return true;
    }
}
