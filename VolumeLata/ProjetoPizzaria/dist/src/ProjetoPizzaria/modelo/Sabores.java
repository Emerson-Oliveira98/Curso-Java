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
public class Sabores {
    private int IdSabor;
    private String NomeSabor;
    private double valor;
    private String tamanho,tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    

    public int getIdSabor() {
        return IdSabor;
    }

    public void setIdSabor(int IdSabor) {
        this.IdSabor = IdSabor;
    }

    public String getNomeSabor() {
        return NomeSabor;
    }

    public void setNomeSabor(String NomeSabor) {
        this.NomeSabor = NomeSabor;
    }
    
    
}
