package br.furb.model;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ServicoAnaliseFluxoObserver extends ServicoObserver {

    @Override
    public void execute(ContaCorrente contaCorrente) {
        System.out.println(this.getClass().getSimpleName());
    }
    
}
