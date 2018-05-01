package br.furb.persistence.factory;

import br.furb.model.AbstractPersistentPojo;
import br.furb.model.Cliente;
import br.furb.model.ContaCorrente;
import br.furb.persistence.IPersistence;
import br.furb.persistence.memory.ClienteMemoryPersistence;
import br.furb.persistence.memory.ContaMemoryPersistence;

/**
 * Responsavel por retornar as instancias
 * das classes que fazem a persistencia usando
 * a memoria.
 * 
 * @author Ruan Schuartz Russi
 */
public class MemoryPersistenceFactory implements IPersistenceFactory {

    @Override
    public <T extends AbstractPersistentPojo> IPersistence getPersistence(Class<T> persistentPojoClass) {
        if (persistentPojoClass == Cliente.class)
            return new ClienteMemoryPersistence();
        else if (persistentPojoClass == ContaCorrente.class)
            return new ContaMemoryPersistence();
        
        return null;
    }
}
