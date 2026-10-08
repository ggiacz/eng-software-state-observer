package state_observer;

public class ChamadoResolvido extends ChamadoEstado {

    private ChamadoResolvido() {
    }

    private static ChamadoResolvido instance = new ChamadoResolvido();

    public static ChamadoResolvido getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Resolvido";
    }

    @Override
    public boolean fechar(Chamado chamado) {
        chamado.setEstado(ChamadoFechado.getInstance());
        return true;
    }
}
