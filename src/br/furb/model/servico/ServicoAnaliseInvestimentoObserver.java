package br.furb.model.servico;

import br.furb.exception.ExecucaoServicoException;
import br.furb.model.Operacao;
import br.furb.model.TipoOperacao;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ServicoAnaliseInvestimentoObserver extends ServicoObserver {

    @Override
    public void execute(Operacao operacao) throws ExecucaoServicoException {
        if (TipoOperacao.ENTRADA == operacao.getTipo()) {
            mostrarMessagem("Analise de Investimento", operacao.toString());
        }
    }
    
}
