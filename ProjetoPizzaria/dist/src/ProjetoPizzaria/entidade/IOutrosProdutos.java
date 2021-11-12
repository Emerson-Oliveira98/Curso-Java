/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.entidade;

import ProjetoPizzaria.modelo.OutrosProdutos;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Casa
*/
public interface IOutrosProdutos {
    public void cadastrarProdutos(OutrosProdutos op);
    public void pesquisaInicial(OutrosProdutos op, JTable tblProdutos);
    public void pesquisarPorNome(OutrosProdutos op, JTable tblProdutos, JTextField txtNome);
    public void deletarProduto(OutrosProdutos op, JTable tblProdutos);
    public void alterarNomeQuantidadePreco(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int quantidade, double preco);
    public void alterarNomePreco(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double preco);
    public void alterarNomeQuantidade(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int quantidade);
    public void alterarPrecoQuantidade(OutrosProdutos op, JTable tblProdutos, double preco, int quantidade);
    public void alterarNome(OutrosProdutos op, JTable tblProdutos, JTextField txtNome);
    public void alterarQuantidade(OutrosProdutos op, JTable tblProdutos, int quantidade);
    public void alterarPreco(OutrosProdutos op, JTable tblProdutos, double preco);
    public void pesquisarPorId(OutrosProdutos op, JTable tblProdutos, int id);
    public void pesquisarPorNomePrecoIgualQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoIgualQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoIgualQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoMaiorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoMaiorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoMaiorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoMenorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoMenorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoMenorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q);
    public void pesquisarPorNomePrecoIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p);
    public void pesquisarPorNomePrecoMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p);
    public void pesquisarPorNomePrecoMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p);
    public void pesquisarPorNomeQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int q);
    public void pesquisarPorNomeQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int q);
    public void pesquisarPorNomeQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int q);
    public void pesquisarPorPrecoIgualQuantidadeIgual(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoIgualQuantidadeMaior(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoIgualQuantidadeMenor(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoMaiorQuantidadeIgual(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoMaiorQuantidadeMaior(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoMaiorQuantidadeMenor(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoMenorQuantidadeIgual(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoMenorQuantidadeMaior(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoMenorQuantidadeMenor(OutrosProdutos op,JTable tblProdutos, double p, int q);
    public void pesquisarPorPrecoIgual(OutrosProdutos op, JTable tblProdutos, double p);
    public void pesquisarPorPrecoMaior(OutrosProdutos op, JTable tblProdutos, double p);
    public void pesquisarPorPrecoMenor(OutrosProdutos op, JTable tblProdutos, double p);
    public void pesquisarPorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, int q);
    public void pesquisarPorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, int q);
    public void pesquisarPorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, int q); 
    public void atualizarEstoqueProdutos(OutrosProdutos op, JTable tblProdutos, JTextField txtQuantidade);
    public void alterarDados(OutrosProdutos op,JTable tblProdutos, JTextField txtNome,double preco, int quantidade, int quantMax, int quantMin);
    
}
