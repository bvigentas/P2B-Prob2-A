package br.furb.persistence.filter;

import br.furb.model.Cliente;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaCorrenteFilter extends AbstractPersistenceFilter {
    
    private Cliente cliente;

    public ContaCorrenteFilter(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
