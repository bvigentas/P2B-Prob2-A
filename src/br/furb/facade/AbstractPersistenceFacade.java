package br.furb.facade;

import br.furb.config.SystemConfig;
import br.furb.model.AbstractPersistentPojo;
import br.furb.persistence.IPersistence;
import br.furb.persistence.filter.AbstractPersistenceFilter;
import java.util.List;

/**
 *
 * @author Ruan Schuartz Russi
 * @param <T>
 * @param <F>
 */
public abstract class AbstractPersistenceFacade<T extends AbstractPersistentPojo, F extends AbstractPersistenceFilter> {
    
    private final IPersistence<T, F> persistence;
    
    public AbstractPersistenceFacade(Class<T> persistentPojoClass) {
        this.persistence = SystemConfig.getPersistenceFactory().getPersistence(persistentPojoClass);
    }
    
    public void save(T t) throws IllegalArgumentException {
        this.persistence.save(t);
    }
    
    public void remove(Long id) throws IllegalArgumentException {
        this.persistence.remove(id);
    }
    
    public List<T> search(F filter) {
        return this.persistence.search(filter);
    }
    
    public T findById(Long id) {
        return this.persistence.findById(id);
    }
}
