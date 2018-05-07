package br.furb.facade;

import br.furb.model.Cliente;
import br.furb.persistence.filter.AbstractPersistenceFilter;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClientePersistenceFacade extends AbstractPersistenceFacade<Cliente, AbstractPersistenceFilter> {

    public ClientePersistenceFacade() {
        super(Cliente.class);
    }
}
