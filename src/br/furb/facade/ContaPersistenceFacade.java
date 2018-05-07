package br.furb.facade;

import br.furb.model.ContaCorrente;
import br.furb.persistence.filter.ContaCorrenteFilter;
import java.util.List;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaPersistenceFacade extends AbstractPersistenceFacade<ContaCorrente, ContaCorrenteFilter> {

    public ContaPersistenceFacade() {
        super(ContaCorrente.class);
    }
    
    public ContaCorrente buscarContaPorNumero(int numero) throws IllegalArgumentException {
        ContaCorrenteFilter filter = new ContaCorrenteFilter();
        filter.setFilter(String.valueOf(numero));
        
        List<ContaCorrente> contas = persistence.search(filter);
        
        if (contas == null || contas.isEmpty()) {
            throw  new IllegalArgumentException(String.format("Conta com o numero %s nao existe",
                    String.valueOf(numero)));
        }
        return contas.get(0);
    }
}
