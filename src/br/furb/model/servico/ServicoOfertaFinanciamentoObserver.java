package br.furb.model.servico;

import br.furb.exception.ExecucaoServicoException;
import br.furb.model.Operacao;
import br.furb.model.TipoOperacao;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ServicoOfertaFinanciamentoObserver extends ServicoObserver {

    @Override
    public void execute(Operacao operacao) throws ExecucaoServicoException {
        if (TipoOperacao.SAIDA == operacao.getTipo()) {
            mostrarMessagem("Oferta de Financiamento", operacao.toString());
        }
    }
    
}
