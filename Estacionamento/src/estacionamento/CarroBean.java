/*
Projeto:    Estacionamento
Autor:      Emerson Moreno de Oliveira
RA:         2090782021004
Data:       21/05/2021
Objetivo:   Classe de dados equivalente a tabela carro
*/

package estacionamento;

public class CarroBean {

    private String placa;
    private String cor;
    private String descricao;
    
// metodo construtor
   public void CarroBeans(){
       this.placa = "";
       this.cor = "";
       this.descricao = "";
   } 
    
    
    //metodos getts/setters
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
