package br.furb.persistence.filter;

/**
 *
 * @author Ruan Schuartz Russi
 */
public abstract class AbstractPersistenceFilter {
    
    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }  
}
