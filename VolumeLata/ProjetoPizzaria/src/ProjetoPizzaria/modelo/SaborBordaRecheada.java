/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.modelo;

/**
 *
 * @author Casa
 */
public class SaborBordaRecheada {
    private int IdSaborBordaRecheada;
    private String NomeSabor;
    private Double Valor;

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public int getIdSaborBordaRecheada() {
        return IdSaborBordaRecheada;
    }

    public void setIdSaborBordaRecheada(int IdSaborBordaRecheada) {
        this.IdSaborBordaRecheada = IdSaborBordaRecheada;
    }

    public String getNomeSabor() {
        return NomeSabor;
    }

    public void setNomeSabor(String NomeSabor) {
        this.NomeSabor = NomeSabor;
    }
    
    
}
