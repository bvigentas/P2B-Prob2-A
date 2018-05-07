package br.furb.model.servico;

import br.furb.exception.ExecucaoServicoException;
import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;
import br.furb.model.Operacao;
import java.util.StringJoiner;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ServicoNotificacaoObserver extends ServicoObserver {

    @Override
    public void execute(Operacao operacao) throws ExecucaoServicoException {
        Cliente cliente = operacao.getConta().getCliente();
        StringJoiner joiner = new StringJoiner("  ");
        
        joiner.add("A notificacao '")
              .add(operacao.toString())
              .add("'")
              .add("foi enviada ao cliente")
              .add(cliente.getNome())
              .add("via");
        
        if (cliente instanceof ClientePessoaFisica) {
            if (((ClientePessoaFisica) cliente).getReceberNotificacoesPorWhatsapp()) {
                joiner.add(" Whatsapp ");
                
                if (((ClientePessoaFisica) cliente).getReceberNotificacoesPorSms()) {
                    joiner.add(" e SMS");
                }
            } else if(((ClientePessoaFisica) cliente).getReceberNotificacoesPorSms()) {
                joiner.add("SMS");
            } else {
                throw new ExecucaoServicoException(String.format(
                    "Nao foi definido nenhum tipo de envio de notificacao para o cliente %s", cliente.getNome()));
            }
        } else {
            joiner.add("JMS para o server")
                  .add(((ClientePessoaJuridica) cliente).getServidorJMS());
        }
        
        mostrarMessagem("Notificacao", joiner.toString());
    }

}
