package br.furb.facade;

import br.furb.model.AbstractPersistentPojo;
import br.furb.persistence.IPersistence;
import br.furb.persistence.factory.IPersistentPojoFactory;
import java.util.List;

/**
 *
 * @author Ruan Schuartz Russi
 * @param <T>
 */
public abstract class AbstractPersistenceFacade<T extends AbstractPersistentPojo> {
    
    private final IPersistence persistence;
    
    public AbstractPersistenceFacade() {
        this.persistence = getFactoryInstance().getPersistenceImpl();
    }
    
    public abstract IPersistentPojoFactory getFactoryInstance();
    
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
