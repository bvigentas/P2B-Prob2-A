package br.furb.facade;

import br.furb.model.ContaCorrente;
import br.furb.persistence.filter.ContaCorrenteFilter;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaPersistenceFacade extends AbstractPersistenceFacade<ContaCorrente, ContaCorrenteFilter> {

    public ContaPersistenceFacade() {
        super(ContaCorrente.class);
    }
}
