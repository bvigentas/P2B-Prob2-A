package br.furb.model;



/**
 *
 * @author marcel
 */
public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private Boolean receberNotificacoesPorSms;
    private Boolean receberNotificacoesPorWhatsapp;
    
    
    public ClientePessoaFisica(String nome, String telCelular, String telFixo, String cpf) {
        super(nome, telCelular, telFixo);
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }  

    public Boolean getReceberNotificacoesPorSms() {
        return receberNotificacoesPorSms;
    }

    public void setReceberNotificacoesPorSms(Boolean receberNotificacoesPorSms) {
        this.receberNotificacoesPorSms = receberNotificacoesPorSms;
    }

    public Boolean getReceberNotificacoesPorWhatsapp() {
        return receberNotificacoesPorWhatsapp;
    }

    public void setReceberNotificacoesPorWhatsapp(Boolean receberNotificacoesPorWhatsapp) {
        this.receberNotificacoesPorWhatsapp = receberNotificacoesPorWhatsapp;
    }
}
