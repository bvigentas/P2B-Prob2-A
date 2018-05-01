package br.furb.config;

import br.furb.persistence.factory.IPersistenceFactory;
import br.furb.persistence.factory.MemoryPersistenceFactory;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class SystemConfig {
    
    private static IPersistenceFactory persistenceFactory;
    
    public static IPersistenceFactory getPersistenceFactory() {
        if (SystemConfig.persistenceFactory == null) {
            SystemConfig.persistenceFactory = new MemoryPersistenceFactory();
        }
        return SystemConfig.persistenceFactory;
    }
}
