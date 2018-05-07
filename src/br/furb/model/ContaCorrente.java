package br.furb.model;


import br.furb.model.servico.ServicoObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 */

/**
 *
 * @author marcel
 */
public class ContaCorrente extends AbstractPersistentPojo {
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private List<Operacao> operacoes = new ArrayList();
    private List<ServicoObserver> observers;

    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.observers = new ArrayList<>();
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this);
        operacoes.add(oper);
        this.saldo -= valor;
        notifyObservers(oper);
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        operacoes.add(oper);
        this.saldo += valor;
        notifyObservers(oper);
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        operacoes.add(oper);
        this.saldo -= valor;
        notifyObservers(oper);
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        operacoes.add(oper);
        this.saldo += valor;        
        notifyObservers(oper);
    }
    
    public void addObserver(ServicoObserver observer) {
        for (ServicoObserver it : this.observers) {
            if (it.getClass().equals(observer.getClass())) {
                return;
            }
        }
        this.observers.add(observer);
    }
    
    public <T extends ServicoObserver> void removeObserver(Class<T> observerClass) {
        for (int i = 0; i < observers.size(); i++) {
            if (this.observers.get(i).getClass().equals(observerClass)) {
                this.observers.remove(this.observers.get(i));
                break;
            }
        }
    }
    
    public List<ServicoObserver> getObservers() {
        return this.observers;
    }
    
    public void notifyObservers(Operacao operacao){
        for(ServicoObserver observer : this.observers){
            observer.execute(operacao);
        }
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }
    
    @Override
    public String toString(){
        return this.getChave();
    }
}
