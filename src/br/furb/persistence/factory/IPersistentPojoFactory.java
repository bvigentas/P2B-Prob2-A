package br.furb.persistence.factory;

import br.furb.persistence.IPersistence;

/**
 *  Interface para as factorys de persistencia do sistema.
 * 
 * @author Ruan Schuartz Russi
 */
public interface IPersistentPojoFactory {
    
    public IPersistence getPersistenceImpl();
    
}
