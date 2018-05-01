package br.furb.model;

/**
 *  Abstrai comportamentos
 * de classes persistentes do sistema.
 * 
 * @author Ruan Schuartz Russi
 */
public class AbstractPersistentPojo {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
