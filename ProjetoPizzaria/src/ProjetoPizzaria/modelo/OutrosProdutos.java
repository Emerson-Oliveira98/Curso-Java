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
public class OutrosProdutos {
    private int IdOutrosProdutos;
    private String nomeProduto;
    private double precoProduto;
    private int quantidade;
    private int quantMax,quantMin;

    public int getQuantMax() {
        return quantMax;
    }

    public void setQuantMax(int quantMax) {
        this.quantMax = quantMax;
    }

    public int getQuantMin() {
        return quantMin;
    }

    public void setQuantMin(int quantMin) {
        this.quantMin = quantMin;
    }

    public int getIdOutrosProdutos() {
        return IdOutrosProdutos;
    }

    public void setIdOutrosProdutos(int IdOutrosProdutos) {
        this.IdOutrosProdutos = IdOutrosProdutos;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
