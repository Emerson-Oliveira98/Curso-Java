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
public class IngredientesPizza {
   private int IdIngredientesPizza;
   private String NomeIngrediente;
   private int Quantidade;
   private String TipoDeUnidade;
   private int quantidadeMax,quantidadeMin;

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public void setQuantidadeMax(int quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public String getTipoDeUnidade() {
        return TipoDeUnidade;
    }

    public void setTipoDeUnidade(String TipoDeUnidade) {
        this.TipoDeUnidade = TipoDeUnidade;
    }

    public int getIdIngredientesPizza() {
        return IdIngredientesPizza;
    }

    public void setIdIngredientesPizza(int IdIngredientesPizza) {
        this.IdIngredientesPizza = IdIngredientesPizza;
    }

    public String getNomeIngrediente() {
        return NomeIngrediente;
    }

    public void setNomeIngrediente(String NomeIngrediente) {
        this.NomeIngrediente = NomeIngrediente;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

  
}
