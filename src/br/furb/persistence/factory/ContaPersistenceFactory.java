package br.furb.persistence.factory;

import br.furb.config.SystemConfig;
import br.furb.persistence.IPersistence;
import br.furb.persistence.memory.ContaMemoryPersistence;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaPersistenceFactory implements IPersistentPojoFactory {

    @Override
    public IPersistence getPersistenceImpl() {
        switch (SystemConfig.getPersistenceType()) {
            case MEMORY:
                return new ContaMemoryPersistence();
        }
        return null;
    }
    
}
