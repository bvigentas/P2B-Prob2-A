package br.furb.persistence.factory;

import br.furb.model.AbstractPersistentPojo;
import br.furb.model.Cliente;
import br.furb.model.ContaCorrente;
import br.furb.persistence.IPersistence;
import br.furb.persistence.memory.ClienteMemoryPersistence;
import br.furb.persistence.memory.ContaMemoryPersistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsavel por retornar as instancias
 * das classes que fazem a persistencia usando
 * a memoria.
 * 
 * @author Ruan Schuartz Russi
 */
public class MemoryPersistenceFactory implements IPersistenceFactory {

    /**
     * Evita que mais de uma instancia seja criada. Isso evita
     * que dados sejam salvos em instancias diferentes.
     */
    private static final Map<Class<?>, IPersistence> INSTANCES = new HashMap<>();
    
    @Override
    public <T extends AbstractPersistentPojo> IPersistence getPersistence(Class<T> persistentPojoClass) {
        if (MemoryPersistenceFactory.INSTANCES.containsKey(persistentPojoClass)) {
            return MemoryPersistenceFactory.INSTANCES.get(persistentPojoClass);
        }
        
        IPersistence persistence = null;
        
        if (persistentPojoClass == Cliente.class)
            persistence = new ClienteMemoryPersistence();
        else if (persistentPojoClass == ContaCorrente.class)
            persistence = new ContaMemoryPersistence();
        
        if (persistence != null) {
            MemoryPersistenceFactory.INSTANCES.put(persistentPojoClass, persistence);
            return persistence;
        }
        
        return null;
    }
}
