
package br.furb.persistence.memory;

import br.furb.model.AbstractPersistentPojo;
import br.furb.persistence.IPersistence;
import br.furb.util.Guard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ruan Schuartz Russi
 * @param <T>
 */
public abstract class AbstractMemoryPersistence<T extends AbstractPersistentPojo> 
       implements IPersistence<T> {
    
    private final Map<Long, T> persistedObjects;
    private Long idSequence;
    
    public AbstractMemoryPersistence() {
        this.persistedObjects = new HashMap<>();
        this.idSequence = 0L;
    }
    
    /**
     * Indica se o atributo t e valido para o filtro filter.
     * 
     * @param t AbstractPersistentPojo que deve ser validado.
     * @param filter Filtra a ser aplicado no AbstractPersistentPojo.
     * @return Flag indicando se o AbstractPersistentPojo e valido para o filtro.
     */
    protected abstract Boolean respectFilter(T t, String filter);

    @Override
    public void save(T t) throws IllegalArgumentException {
        Guard.isNotNull(t, "Objeto a ser persistido");
        
        if (t.getId() == null) {
            t.setId(this.idSequence);
            this.idSequence ++;
        }
        
        this.persistedObjects.put(t.getId(), t);
    }

    @Override
    public void remove(Long id) throws IllegalArgumentException {
        Guard.isNotNull(id, "Id e obrigatorio.");
        this.persistedObjects.remove(id);
    }

    @Override
    public List<T> search(String filter) {
        List<T> results = new ArrayList<>();
        
        for (T t : this.persistedObjects.values()) {
            if (respectFilter(t, filter)) {
                results.add(t);
            }
        }
        
        return results;
    }

    @Override
    public T findById(Long id) throws IllegalArgumentException {
        Guard.isNotNull(id, "Id e obrigatorio.");
        
        if (this.persistedObjects.containsKey(id)) {
            return this.persistedObjects.get(id);
        }
        
        throw new IllegalArgumentException("Nao foi encontrado nenhum objeto com o id informado.");
    }
    
    protected Map<Long, T> getPersistedObjects() {
        return this.persistedObjects;
    }
}
