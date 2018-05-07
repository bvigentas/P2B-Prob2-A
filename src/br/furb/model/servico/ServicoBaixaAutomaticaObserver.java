package br.furb.model.servico;

import br.furb.exception.ExecucaoServicoException;
import br.furb.model.Operacao;


/**
 *
 * @author Ruan Schuartz Russi
 */
public class ServicoBaixaAutomaticaObserver extends ServicoObserver {

    @Override
    public void execute(Operacao operacao) throws ExecucaoServicoException {
         mostrarMessagem("Baixa Automatica", operacao.toString());
    }
    
}
