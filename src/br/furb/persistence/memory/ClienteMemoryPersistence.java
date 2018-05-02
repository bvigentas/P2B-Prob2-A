package br.furb.persistence.memory;

import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;
import br.furb.util.StringUtil;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClienteMemoryPersistence extends AbstractMemoryPersistence<Cliente> {

    @Override
    protected Boolean respectFilter(Cliente t, String filter) {
        if (StringUtil.isNull(filter)) {
            return Boolean.TRUE;
        }
        
        Boolean filtro = StringUtil.possuemPartesIguais(t.getNome(), filter) ||
               StringUtil.possuemPartesIguais(t.getTelCelular(), filter) ||
               StringUtil.possuemPartesIguais(t.getTelFixo(), filter);
        
        if (!filtro) {
            if (t instanceof ClientePessoaFisica) {
                filtro = StringUtil.possuemPartesIguais(((ClientePessoaFisica)t).getCpf(), filter);
            } else {
                filtro = StringUtil.possuemPartesIguais(((ClientePessoaJuridica)t).getCnpj(), filter) ||
                         StringUtil.possuemPartesIguais(((ClientePessoaJuridica)t).getServidorJMS(), filter);
            }
        }
        
        return filtro;
    }
      
}
