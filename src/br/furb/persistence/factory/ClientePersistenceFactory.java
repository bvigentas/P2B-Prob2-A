package br.furb.persistence.factory;

import br.furb.config.SystemConfig;
import br.furb.persistence.IPersistence;
import br.furb.persistence.memory.ClienteMemoryPersistence;

/**
 *
 * @author robot
 */
public class ClientePersistenceFactory implements IPersistentPojoFactory {

    @Override
    public IPersistence getPersistenceImpl() {
        switch (SystemConfig.getPersistenceType()) {
            case MEMORY:
                return new ClienteMemoryPersistence();
        }
        return null;
    }
    
}
