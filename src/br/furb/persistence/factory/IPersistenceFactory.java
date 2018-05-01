package br.furb.persistence.factory;

import br.furb.model.AbstractPersistentPojo;
import br.furb.persistence.IPersistence;

/**
 * Permiti fazer de maneira simplificada
 * a troca da estrategia de persistencia.
 * 
 * @author Ruan Schuartz Russi
 */
public interface IPersistenceFactory {
    
    public <T extends AbstractPersistentPojo> IPersistence getPersistence(Class<T> persistentPojoClass);
    
}
