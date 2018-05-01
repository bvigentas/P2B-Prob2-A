package br.furb.facade;

import br.furb.model.ContaCorrente;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaPersistenceFacade extends AbstractPersistenceFacade<ContaCorrente> {

    public ContaPersistenceFacade() {
        super(ContaCorrente.class);
    }
}
