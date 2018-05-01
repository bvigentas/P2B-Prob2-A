package br.furb.facade;

import br.furb.config.SystemConfig;
import br.furb.model.AbstractPersistentPojo;
import br.furb.persistence.IPersistence;
import java.util.List;

/**
 *
 * @author Ruan Schuartz Russi
 * @param <T>
 */
public abstract class AbstractPersistenceFacade<T extends AbstractPersistentPojo> {
    
    private final IPersistence persistence;
    
    public AbstractPersistenceFacade(Class<T> persistentPojoClass) {
        this.persistence = SystemConfig.getPersistenceFactory().getPersistence(persistentPojoClass);
    }
    
    public void save(T t) throws IllegalArgumentException {
        this.persistence.save(t);
    }
    
    public void remove(Long id) throws IllegalArgumentException {
        this.persistence.remove(id);
    }
    
    public List<T> search(String filter) {
        return this.persistence.search(filter);
    }
}
