package state_observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChamadoTest {

    Chamado chamado;
    Solicitante solicitante;

    @BeforeEach
    void setUp() {
        solicitante = new Solicitante("Solicitante 1");
        chamado = new Chamado(solicitante);
        chamado.setDescricao("Chamado 1");
    }

    @Test
    void deveIniciarChamadoComoAberto() {
        assertEquals(
                ChamadoAberto.getInstance(),
                chamado.getEstado()
        );
    }

    @Test
    void deveNotificarSolicitanteAoAtenderChamado() {
        solicitante.acompanhar(chamado);

        chamado.atender();

        assertEquals(
                "Solicitante 1, chamado atualizado: Chamado{descricao='Chamado 1', estado=Em Atendimento}",
                solicitante.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarSolicitanteAoResolverChamado() {
        solicitante.acompanhar(chamado);

        chamado.atender();
        chamado.resolver();

        assertEquals(
                "Solicitante 1, chamado atualizado: Chamado{descricao='Chamado 1', estado=Resolvido}",
                solicitante.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarSolicitanteAoFecharChamado() {
        solicitante.acompanhar(chamado);

        chamado.atender();
        chamado.resolver();
        chamado.fechar();

        assertEquals(
                "Solicitante 1, chamado atualizado: Chamado{descricao='Chamado 1', estado=Fechado}",
                solicitante.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarSolicitanteAoCancelarChamado() {
        solicitante.acompanhar(chamado);

        chamado.cancelar();

        assertEquals(
                "Solicitante 1, chamado atualizado: Chamado{descricao='Chamado 1', estado=Cancelado}",
                solicitante.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarDoisSolicitantes() {
        Solicitante solicitante2 = new Solicitante("Solicitante 2");

        solicitante.acompanhar(chamado);
        solicitante2.acompanhar(chamado);

        chamado.atender();

        assertEquals(
                "Solicitante 1, chamado atualizado: Chamado{descricao='Chamado 1', estado=Em Atendimento}",
                solicitante.getUltimaNotificacao()
        );

        assertEquals(
                "Solicitante 2, chamado atualizado: Chamado{descricao='Chamado 1', estado=Em Atendimento}",
                solicitante2.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarSolicitanteNaoInscrito() {
        chamado.atender();

        assertEquals(
                null,
                solicitante.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarSolicitanteQuandoEstadoNaoMudar() {
        solicitante.acompanhar(chamado);

        assertFalse(chamado.resolver());

        assertEquals(
                null,
                solicitante.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarApenasSolicitanteDoChamadoAcompanhado() {

        Solicitante solicitante2 = new Solicitante("Solicitante 2");
        Chamado chamado2 = new Chamado(solicitante2);
        chamado2.setDescricao("Chamado 2");

        solicitante.acompanhar(chamado);
        solicitante2.acompanhar(chamado2);

        chamado.atender();

        assertEquals(
                "Solicitante 1, chamado atualizado: Chamado{descricao='Chamado 1', estado=Em Atendimento}",
                solicitante.getUltimaNotificacao()
        );

        assertEquals(
                null,
                solicitante2.getUltimaNotificacao()
        );
    }
}
