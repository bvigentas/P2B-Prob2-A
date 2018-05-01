package br.furb.facade;

import br.furb.model.Cliente;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClientePersistenceFacade extends AbstractPersistenceFacade<Cliente> {

    public ClientePersistenceFacade() {
        super(Cliente.class);
    }

    
}
