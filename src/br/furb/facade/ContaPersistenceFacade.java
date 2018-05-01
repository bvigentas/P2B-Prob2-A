package br.furb.facade;

import br.furb.model.ContaCorrente;
import br.furb.persistence.factory.ContaPersistenceFactory;
import br.furb.persistence.factory.IPersistentPojoFactory;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaPersistenceFacade extends AbstractPersistenceFacade<ContaCorrente> {

    @Override
    public IPersistentPojoFactory getFactoryInstance() {
        return new ContaPersistenceFactory();
    }
    
}
