/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.entidade;

import ProjetoPizzaria.modelo.Sabores;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Casa
 */
public interface ISabores {
    public void PesquisarTudo(Sabores sab, JTable tblSabores);
    public void PesquisarPorID(Sabores sab,JTable tblSabores, int ID);
    public void PesquisarPorNome(Sabores sab , JTable tblSabores, JTextField txtNome);
    public void PesquisarPorNomeValorTamanho(Sabores sab,JTable tblSabores, String nome,double valor, String simbolo,String tamanho);
    public void PesquisarPorNomeValor(Sabores sab,JTable tblSabores, String nome,double valor, String simbolo);
    public void PesquisarPorNomeTamanho(Sabores sab, JTable tblSabores, String nome, String tamanho);
    public void PesquisarValorTamanho(Sabores sab,JTable tblSabores,String simbolo,double valor,String tamanho);
    public void PesquisarPorTamanho(Sabores sab,JTable tblSabores,String tamanho);
    public void PesquisarPorValor(Sabores sab,JTable tblSabores,String simbolo,double valor);
    public void PesquisarPorNomeValorTamanhoTipo(Sabores sab,JTable tblSabores,String nome,double valor,String simbolo, String tamanho,String tipo);
    public void PesquisarPorNomeValorTipo(Sabores sab,JTable tblSabores,String nome,double valor,String simbolo,String tipo);
    public void PesquisarPorNomeTamanhoTipo(Sabores sab,JTable tblSabores,String nome,String tamanho,String tipo);
    public void PesquisarPorNomeTipo(Sabores sab,JTable tblSabores,String nome,String tipo);
    public void PesquisarPorValorTipo(Sabores sab,JTable tblSabores, double valor,String simbolo,String tipo);
    public void PesquisarPorTamanhoTipo(Sabores sab,JTable tblSabores, String tamanho, String tipo);
    public void PesquisarPorTipo(Sabores sab,JTable tblSabores, String tipo);
    public void PesquisarPorValorTamanhoTipo(Sabores sab,JTable tblSabores, double valor,String simbolo, String tamanho,String tipo);
    public void AdicionarSabor(Sabores sab);
    public void AlterarDados(Sabores sab,JTable tblSabores, String nome, double valor, String tamanho,String tipo);
    public void DeletarNome(Sabores sab,JTable tblSabores);
}
