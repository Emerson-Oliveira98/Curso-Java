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
public class Pizza {
int IdPizzaPri,IdPizza,quantidadeSabores,tempoDePreparo,quantidadeIngrediente,IdSaborPizza_fk,IdIngrediente_fk,IdSaborBorda_fk;
String tamanhoPizza,nomePizza,tipoDePizza,modoDePreparo,imagem,disponibilidade;
double precoTotal;

    public int getIdSaborPizza_fk() {
        return IdSaborPizza_fk;
    }

    public void setIdSaborPizza_fk(int IdSaborPizza_fk) {
        this.IdSaborPizza_fk = IdSaborPizza_fk;
    }

    public int getIdIngrediente_fk() {
        return IdIngrediente_fk;
    }

    public void setIdIngrediente_fk(int IdIngrediente_fk) {
        this.IdIngrediente_fk = IdIngrediente_fk;
    }

    public int getIdSaborBorda_fk() {
        return IdSaborBorda_fk;
    }

    public void setIdSaborBorda_fk(int IdSaborBorda_fk) {
        this.IdSaborBorda_fk = IdSaborBorda_fk;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getIdPizzaPri() {
        return IdPizzaPri;
    }

    public void setIdPizzaPri(int IdPizzaPri) {
        this.IdPizzaPri = IdPizzaPri;
    }

    public int getIdPizza() {
        return IdPizza;
    }

    public void setIdPizza(int IdPizza) {
        this.IdPizza = IdPizza;
    }

    public int getQuantidadeSabores() {
        return quantidadeSabores;
    }

    public void setQuantidadeSabores(int quantidadeSabores) {
        this.quantidadeSabores = quantidadeSabores;
    }

    public int getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(int tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public int getQuantidadeIngrediente() {
        return quantidadeIngrediente;
    }

    public void setQuantidadeIngrediente(int quantidadeIngrediente) {
        this.quantidadeIngrediente = quantidadeIngrediente;
    }

    public String getTamanhoPizza() {
        return tamanhoPizza;
    }

    public void setTamanhoPizza(String tamanhoPizza) {
        this.tamanhoPizza = tamanhoPizza;
    }

    public String getNomePizza() {
        return nomePizza;
    }

    public void setNomePizza(String nomePizza) {
        this.nomePizza = nomePizza;
    }

    public String getTipoDePizza() {
        return tipoDePizza;
    }

    public void setTipoDePizza(String tipoDePizza) {
        this.tipoDePizza = tipoDePizza;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }




}
