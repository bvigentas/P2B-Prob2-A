package br.furb.persistence.memory;

import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;
import br.furb.persistence.filter.ClienteFilter;
import br.furb.util.StringUtil;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClienteMemoryPersistence extends AbstractMemoryPersistence<Cliente, ClienteFilter> {

    @Override
    protected Boolean respectFilter(Cliente t, ClienteFilter filter) {
        if (filter == null || StringUtil.isNull(filter.getFilter())) {
            return Boolean.TRUE;
        }
        
        Boolean filtro = StringUtil.possuemPartesIguais(t.getNome(), filter.getFilter()) ||
               StringUtil.possuemPartesIguais(t.getTelCelular(), filter.getFilter()) ||
               StringUtil.possuemPartesIguais(t.getTelFixo(), filter.getFilter());
        
        if (!filtro) {
            if (t instanceof ClientePessoaFisica) {
                filtro = StringUtil.possuemPartesIguais(((ClientePessoaFisica)t).getCpf(), filter.getFilter());
            } else {
                filtro = StringUtil.possuemPartesIguais(((ClientePessoaJuridica)t).getCnpj(), filter.getFilter()) ||
                         StringUtil.possuemPartesIguais(((ClientePessoaJuridica)t).getServidorJMS(), filter.getFilter());
            }
        }
        
        return filtro;
    }
      
}
