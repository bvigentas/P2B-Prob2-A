package br.furb.model.servico;

import br.furb.exception.ExecucaoServicoException;
import br.furb.model.Operacao;

/**
 *
 * @author Ruan Schuartz Russi
 */
public abstract class ServicoObserver {
    
    public abstract void execute(Operacao operacao) throws ExecucaoServicoException;

    protected void mostrarMessagem(String nomeServico, String mensagem) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n==============================\n");
        
        builder.append(String.format("Executando o servico %s ", nomeServico));
        builder.append("\n-------------------------------------------------------------\n\n");
        
        builder.append(mensagem);
        
        builder.append("\n==============================\n");
        
        System.out.println(builder.toString());
    }
    
}
