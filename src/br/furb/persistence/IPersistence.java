package br.furb.persistence;

import br.furb.model.AbstractPersistentPojo;
import br.furb.persistence.filter.AbstractPersistenceFilter;
import java.util.List;

/**
 * Realiza a persistencia dos objetos.
 * 
 * @author Ruan Schuartz Russi
 * @param <T>
 */
public interface IPersistence<T extends AbstractPersistentPojo, F extends AbstractPersistenceFilter> {
    
    /**
     * Faz a persistencia de um AbstractPersistentPojo.
     * Caso ja exista, apenas atualiza os dados.
     * 
     * @param t AbstractPersistentPojo a ser persistido.
     * @throws java.lang.IllegalArgumentException
     */
    public void save(T t) throws IllegalArgumentException;
    
    /**
     * Faz a remocao de um AbstractPersistentPojo.
     * 
     * @param id Id do AbstractPersistentPojo a ser removido.
     * @throws java.lang.IllegalArgumentException
     */
    public void remove(Long id) throws IllegalArgumentException;
    
    /**
     * Faz a busca dos AbstractPersistentPojo ja persistidos.
     * 
     * @param filter Filtro aplicado na busca.
     * @throws java.lang.IllegalArgumentException
     * @return Lista de AbstractPersistentPojo persistidos que passem no filtro informado.
     */
    public List<T> search(F filter);
    
    /**
     * Busca um AbstractPersistentPojo pelo id.
     * 
     * @param id Id do AbstractPersistentPojo ja persistido.
     * @throws java.lang.IllegalArgumentException
     * @return AbstractPersistentPojo com o id informado.
     */
    public T findById(Long id) throws IllegalArgumentException;
    
}
