package br.furb.facade;

import br.furb.model.Cliente;
import br.furb.persistence.factory.ClientePersistenceFactory;
import br.furb.persistence.factory.IPersistentPojoFactory;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClientePersistenceFacade extends AbstractPersistenceFacade<Cliente> {

    @Override
    public IPersistentPojoFactory getFactoryInstance() {
        return new ClientePersistenceFactory();
    }
}
